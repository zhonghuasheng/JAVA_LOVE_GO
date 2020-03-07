package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.common.Result;
import com.zhonghuasheng.seckill.domain.Student;
import com.zhonghuasheng.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("Hello World");
    }

    @GetMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @GetMapping("/thymeleaf")
    public String hi(Model model) {
        model.addAttribute("name", "Luke");

        return "demo";
    }

    @GetMapping("/db/get")
    @ResponseBody
    public Result<Student> dbGet() {
        Student student = userService.getById(10000);
        return Result.success(student);
    }

    @GetMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx() {
        userService.tx();
        return Result.success(true);
    }
}
