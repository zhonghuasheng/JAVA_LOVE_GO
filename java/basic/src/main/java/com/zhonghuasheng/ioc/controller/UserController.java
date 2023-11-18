package com.zhonghuasheng.ioc.controller;

import com.zhonghuasheng.ioc.annotation.MyComponent;
import com.zhonghuasheng.ioc.annotation.MyInject;
import com.zhonghuasheng.ioc.bean.User;
import com.zhonghuasheng.ioc.service.UserService;

@MyComponent
public class UserController {

    @MyInject
    private UserService userService;

    public void getUser() {
        User user = userService.getUser();
        System.out.println(user);
    }
}
