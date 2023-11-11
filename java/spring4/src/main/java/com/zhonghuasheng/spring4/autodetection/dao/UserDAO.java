package com.zhonghuasheng.spring4.autodetection.dao;

import com.zhonghuasheng.spring4.autodetection.model.User;

public interface UserDAO {

    void add(User user);
    User getById(int id);
}
