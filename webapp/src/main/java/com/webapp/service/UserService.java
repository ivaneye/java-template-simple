package com.webapp.service;

import com.mybatis.mapper.UserMapper;
import com.mybatis.model.User;
import com.mybatis.model.UserExample;
import com.web.security.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 15-1-15.
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Encoder encoder;

    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setType(1);  //1为普通用户
        user.setAddTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }

    public User login(User user) {
        UserExample e = new UserExample();
        e.createCriteria().andNameEqualTo(user.getName()).andPasswordEqualTo(user.getPassword());
        List<User> list = userMapper.selectByExample(e);
        return list == null ? null : list.get(0);
    }
}
