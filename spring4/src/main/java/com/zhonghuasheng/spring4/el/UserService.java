package com.zhonghuasheng.spring4.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("UserService的Property")
    private String property;

    public String getProperty() {
        return property;
    }
}
