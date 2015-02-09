package com.webapp.domain;

import com.mybatis.model.User;
import com.mybatis.model.UserExample;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 15-1-15.
 */
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class UserDomain extends User<UserDomain> {

    public void save() {
        this.setType(1);  //1为普通用户
        this.setAddTime(new Date());
        this.setUpdateTime(new Date());
        this.insert();
    }

    public UserDomain login() {
        UserExample e = new UserExample();
        e.createCriteria().andNameEqualTo(this.getName()).andPasswordEqualTo(this.getPassword());
        List<UserDomain> list = new UserDomain().selectByExample(e);
         return list == null ? null : list.get(0);
    }
}
