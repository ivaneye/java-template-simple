package com.web.base;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter{
	public static final String LOGIN_USER_KEY = "login_user";
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession(true);
		String URI = request.getRequestURI();
		//静态资源直接放过 暂时先简单处理一下
		if(URI.contains(".")){
			chain.doFilter(request, response);
		}else if(URI.contains("/account/signinpage") || URI.contains("/account/signin")){
			chain.doFilter(request, response);
		}else if(null == session.getAttribute(LOGIN_USER_KEY)){
			response.sendRedirect("/account/signinpage");
			return;
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
	public void destroy() {
			
	}
}
