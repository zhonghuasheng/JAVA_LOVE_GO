package com.zhonghuasheng.spring4.autodetection.dao;

import org.springframework.stereotype.Repository;

import com.zhonghuasheng.spring4.autodetection.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    @Override
    public void add(User user) {
        System.out.println("Added user");
    }

    @Override
    public User getById(int id) {
        return new User(1, "Luke");
    }
}
