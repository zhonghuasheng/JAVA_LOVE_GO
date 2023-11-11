package com.zhonghuasheng.springcloud.ribbon.controller;

import com.zhonghuasheng.springcloud.ribbon.service.RibbonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class RibbonController {

    //@Autowired
    RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi(@RequestParam String name) {
        return ribbonService.hi(name);
    }
}
