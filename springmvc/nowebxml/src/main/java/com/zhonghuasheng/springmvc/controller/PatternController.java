package com.zhonghuasheng.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pattern")
public class PatternController {

    @GetMapping("/do.xx")
    @ResponseBody
    public String pattern() {
        return "setUseSuffixPatternMatch=false";
    }
}
