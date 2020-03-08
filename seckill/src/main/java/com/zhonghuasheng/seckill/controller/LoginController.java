package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.common.Result;
import com.zhonghuasheng.seckill.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private Logger log = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login")
    @ResponseBody
    public Result<Boolean> login(LoginVo loginVo) {
        log.info(loginVo.toString());

        return Result.success(true);
    }
}
