package com.zhonghuasheng.springmvc.controller;

import com.zhonghuasheng.springmvc.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestExampleController {

    // http://localhost:8080/rest/str
    @RequestMapping(value = "/str", produces={"application/json;charset=UTF-8"})
    public String getStr() {
        return "Hello World";
    }

    @RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
    public User getUser() {
        User user = new User();
        user.setAge(1);
        user.setName("Luke");

        return user;
    }
}
