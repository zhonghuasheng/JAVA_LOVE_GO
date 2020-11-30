package com.zhonghuasheng.springboot.service;

import com.zhonghuasheng.springboot.model.User;

public interface UserService {

    User getUserByPhone(String phone);

    boolean saveUser(User user);
}
