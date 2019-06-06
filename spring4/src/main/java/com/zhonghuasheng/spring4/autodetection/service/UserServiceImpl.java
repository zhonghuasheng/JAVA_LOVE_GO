package com.zhonghuasheng.spring4.autodetection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhonghuasheng.spring4.autodetection.dao.UserDAO;
import com.zhonghuasheng.spring4.autodetection.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

}
