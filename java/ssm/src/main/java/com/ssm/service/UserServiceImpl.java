package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserDao;
import com.ssm.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

}
