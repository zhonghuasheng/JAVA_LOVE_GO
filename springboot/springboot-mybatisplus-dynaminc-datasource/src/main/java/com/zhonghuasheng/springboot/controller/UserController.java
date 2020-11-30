package com.zhonghuasheng.springboot.controller;

import com.zhonghuasheng.springboot.model.User;
import com.zhonghuasheng.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{phone}")
    public User getUserByPhone(@PathVariable("phone") String phone) {
        return userService.getUserByPhone(phone);
    }

    @PostMapping("/save")
    public Boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
