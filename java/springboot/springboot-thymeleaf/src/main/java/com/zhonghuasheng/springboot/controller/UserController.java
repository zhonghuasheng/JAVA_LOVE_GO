package com.zhonghuasheng.springboot.controller;

import com.zhonghuasheng.springboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("info", "user/list");

        return "index";
    }

    @GetMapping("/user")
    public String view(Model model) {
        User user = new User("0001", "Tom", "123456");
        model.addAttribute("user", user);

        return "user/view";
    }

    @GetMapping("/user/list")
    public String list(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("0001", "Tom", "123456"));
        userList.add(new User("0002", "Jom", "123457"));
        userList.add(new User("0003", "Kom", "123458"));
        model.addAttribute("userList", userList);

        return "user/list";
    }

    @GetMapping("/user/edit/{userId}")
    public String edit(@PathVariable String userId, Model model) {
        model.addAttribute("user", new User(userId, "Tom", "123"));

        return "user/view";
    }
}
