package com.webapp.util;

import com.webapp.domain.UserDomain;

/**
 * 存放ThreadLocal变量
 * Created by ivan on 15-1-15.
 */
public class AppContext {

    private static final ThreadLocal<UserDomain> user = new ThreadLocal<UserDomain>();

    public static UserDomain getUser(){
        return user.get();
    }

    public static void setUser(UserDomain userDomain){
        user.set(userDomain);
    }
}
