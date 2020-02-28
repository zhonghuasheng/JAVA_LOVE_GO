package com.zhonghuasheng.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
