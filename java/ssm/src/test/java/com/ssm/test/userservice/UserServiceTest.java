package com.ssm.test.userservice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.model.User;
import com.ssm.service.UserService;
import com.ssm.test.base.SpringTestCase;

public class UserServiceTest extends SpringTestCase {
    @Autowired
    private UserService userService;

    @Test
    public void getUserByIdTest() {
        User user = userService.getUserById(10);
        System.out.println(user.getUserName());
    }
}
