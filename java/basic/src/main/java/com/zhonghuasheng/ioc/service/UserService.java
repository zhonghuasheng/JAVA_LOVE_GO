package com.zhonghuasheng.ioc.service;

import com.zhonghuasheng.ioc.annotation.MyComponent;
import com.zhonghuasheng.ioc.bean.User;

@MyComponent
public class UserService {

    public User getUser() {
        User user = new User("Luke", 18);

        return user;
    }
}
