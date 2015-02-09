package com.mybatis.model;

import com.model.base.BaseDomain;
import com.mybatis.mapper.UserMapper;
import java.util.Date;

public class User<T extends BaseDomain> extends BaseDomain<T, UserExample, UserMapper> {
    private Long recId;

    private String name;

    private String password;

    private Integer type;

    private Date addTime;

    private Date updateTime;

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}