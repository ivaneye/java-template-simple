package com.webapp.tool;

import org.apache.velocity.tools.generic.FormatConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class ParameterTool extends FormatConfig {

    public String loginName() {
        Object userDetails = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if (userDetails != null && userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }
        return "";
    }
}
