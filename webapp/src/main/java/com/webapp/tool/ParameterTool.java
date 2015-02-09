package com.webapp.tool;

import org.apache.velocity.tools.generic.FormatConfig;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ParameterTool extends FormatConfig {

    public String loginName(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String name = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
//                System.out.println(c.getName() + "|" + c.getValue());
                if (c.getName().equals("user")) {
                    String temp = c.getValue();
                    name = temp.split("_")[1];
                    break;
                }
            }
        }
        return name;
    }
}
