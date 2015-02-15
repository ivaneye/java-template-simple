package com.web.security;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * 封装Spring提供的加密类,提供salt
 * Created by ivan on 15-2-15.
 */
public class Encoder extends Md5PasswordEncoder{

    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String encode(String val){
        return encodePassword(val,salt);
    }
}
