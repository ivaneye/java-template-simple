package com.webapp.service;

import com.webapp.domain.UserDomain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by ivan on 15-1-15.
 */

@Service
@Transactional
public class UserService {
    public void save(UserDomain user) {
        user.save();
    }

    public  UserDomain login(UserDomain user) {
        return user.login();
    }
}
