package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.dao.UserDao;
import com.ssm.model.User;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

}
