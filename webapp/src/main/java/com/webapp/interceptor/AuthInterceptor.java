package com.webapp.interceptor;

import com.webapp.domain.UserDomain;
import com.webapp.util.AppContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 简单的权限拦截器
 * Created by ivan on 15-1-14.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();

        if(url.endsWith(".json"))return true;

        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    flag = true;
                    String userStr = c.getValue();
                    String[] tmp = userStr.split("_");
                    UserDomain user = new UserDomain();
                    user.setRecId(Long.parseLong(tmp[0]));
                    user.setName(tmp[1]);
                    user.setPassword(tmp[2]);
                    user.setType(Integer.parseInt(tmp[3]));
                    AppContext.setUser(user);
                    break;
                }
            }
        }
        if(!flag){
          response.sendRedirect("/user/login");
            return false;
        }else {
            return super.preHandle(request, response, handler);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
