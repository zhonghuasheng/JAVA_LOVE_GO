package com.zhonghuasheng.spring4.autodetection.service;

import com.zhonghuasheng.spring4.autodetection.model.User;

public interface UserService {

    void add(User user);
    User getById(int id);
}
