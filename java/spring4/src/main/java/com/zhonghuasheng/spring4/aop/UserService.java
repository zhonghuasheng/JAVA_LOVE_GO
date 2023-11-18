package com.zhonghuasheng.spring4.aop;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Action(name="User注解式拦截register方法")
    public void register(User user) {
        System.out.println(user.toString());
    }
}
