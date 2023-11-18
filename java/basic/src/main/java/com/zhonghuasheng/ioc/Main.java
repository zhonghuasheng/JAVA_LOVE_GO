package com.zhonghuasheng.ioc;

import com.zhonghuasheng.ioc.controller.UserController;

public class Main {

    public static void main(String[] args) {
        UserController userController = (UserController) IocContext.APPLICATIONCONTEXT_MAP.get(UserController.class);
        userController.getUser();
    }

}
