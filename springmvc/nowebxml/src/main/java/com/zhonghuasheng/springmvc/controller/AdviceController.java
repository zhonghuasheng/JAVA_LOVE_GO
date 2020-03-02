package com.zhonghuasheng.springmvc.controller;

import com.zhonghuasheng.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/advice")
public class AdviceController {

    // ControllerAdvice处理全局异常
    @RequestMapping(value = "/error")
    public String error() {
        throw new IllegalArgumentException("ControllerAdvice exception example");
    }

    // 获取全局数据
    @GetMapping("/data")
    @ResponseBody
    public String data(Model model) {
        Map<String, Object> map = model.asMap();
        System.out.println(map); // 打印所有全局数据
        System.out.println(map.get("globalData2")); // 打印指定数据

        return "Global data";
    }

    @GetMapping("/data2")
    @ResponseBody
    public String data2(@ModelAttribute("msg") String msg) {
        return "Global data 2: " + msg;
    }

    // http://localhost:8080/advice/bind?id=1&name=abc&age=12
    @PostMapping("/bind")
    @ResponseBody
    public User bind(User user) {
        return user;
    }

    // http://localhost:8080/advice/bind2?user.id=101&user.name=abc&user.age=12&user2.id=123&user2.name=qwe&user2.age=123
    @PostMapping("/bind2")
    @ResponseBody
    public User bind2(@ModelAttribute("user") User user, @ModelAttribute("user2") User user1) {
        System.out.println(user);
        System.out.println(user1);

        return user;
    }
}
