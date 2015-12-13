package com.webapp.util;

import com.mybatis.model.User;

/**
 * 存放ThreadLocal变量
 * Created by ivan on 15-1-15.
 */
public class AppContext {

    private static final ThreadLocal<User> userThreadLocal = new ThreadLocal<User>();

    public static User getUser() {
        return userThreadLocal.get();
    }

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }
}
