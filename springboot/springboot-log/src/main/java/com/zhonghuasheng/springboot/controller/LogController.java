package com.zhonghuasheng.springboot.controller;

import com.zhonghuasheng.springboot.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class LogController {

    @RequestMapping("/loglevel")
    public String logLevel() {
        log.debug("debug log");
        log.info("info log");
        log.warn("warn log");

        return "success";
    }

    @PutMapping("/changeAllLogLevel/{level}")
    public String changeAllLogLevel(@PathVariable String level) {
        LogUtil.setAllLogLevel(level);

        return "success";
    }

    @PostMapping("/changeLogLevel")
    public String changeLogLevel(HttpServletRequest request) {
        LogUtil.setLogLevel(String.valueOf(request.getParameter("level")),
                String.valueOf(request.getParameter("classFullName")));

        return "success";
    }
}
