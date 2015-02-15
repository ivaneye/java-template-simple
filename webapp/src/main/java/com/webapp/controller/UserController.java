package com.webapp.controller;

import com.webapp.domain.ArticleDomain;
import com.webapp.domain.UserDomain;
import com.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ivan on 15-1-15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String index() {
        return "/user/reg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String _new(Model model, UserDomain user) {
        userService.save(user);
        return "redirect:/article/success";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String show_login() {
        return "/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, UserDomain user,String path, HttpServletResponse resp) {
        UserDomain u = userService.login(user);
        path = path.substring(4,path.length()-4);
        if (u != null) {
            String userStr = u.getRecId() + "_" + u.getName() + "_" + u.getPassword() + "_" + u.getType();
            Cookie c = new Cookie("user", userStr);
            c.setPath("/");
            c.setMaxAge(1800);
            resp.addCookie(c);
        }
        return "redirect:" + path;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String index(String path,HttpServletRequest request,HttpServletResponse resp) {
        path = path.substring(4,path.length()-4);
        Cookie[] cookies = request.getCookies();
        System.out.println("logout");
        if(cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    c.setPath("/");
                   c.setMaxAge(0);
                    resp.addCookie(c);
                    break;
                }
            }
        }
        return "redirect:" + path;
    }

}
