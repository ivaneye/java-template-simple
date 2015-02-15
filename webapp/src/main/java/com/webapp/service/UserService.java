package com.webapp.service;

import com.web.security.Encoder;
import com.webapp.domain.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by ivan on 15-1-15.
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private Encoder encoder;

    public void save(UserDomain user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.save();
    }

    public  UserDomain login(UserDomain user) {
        return user.login();
    }
}
