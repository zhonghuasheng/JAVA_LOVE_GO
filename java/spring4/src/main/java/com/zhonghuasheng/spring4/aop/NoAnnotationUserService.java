package com.zhonghuasheng.spring4.aop;

import org.springframework.stereotype.Service;

@Service
public class NoAnnotationUserService {

    public void register(User user) {
        System.out.println(user.toString());
    }
}
