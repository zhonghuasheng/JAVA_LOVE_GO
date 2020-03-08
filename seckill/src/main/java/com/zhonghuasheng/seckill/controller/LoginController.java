package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.common.Result;
import com.zhonghuasheng.seckill.service.SeckillUserService;
import com.zhonghuasheng.seckill.util.ValidatorUtil;
import com.zhonghuasheng.seckill.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private SeckillUserService seckillUserService;

    private Logger log = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/login")
    @ResponseBody
    public Result<Boolean> login(LoginVo loginVo) {
        log.info(loginVo.toString());
        String password = loginVo.getPassword();
        String mobile = loginVo.getMobile();
        if (StringUtils.isEmpty(password)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if (StringUtils.isEmpty(mobile)) {
            return Result.error(CodeMsg.MOBILE_EMPTY);
        }
        if (!ValidatorUtil.isMobile(mobile)) {
            return Result.error(CodeMsg.MOBILE_FORMAT_ERROR);
        }

        // 登陆
        CodeMsg cm = seckillUserService.login(loginVo);
        if (0 == cm.getCode()) {
            return Result.success(true);
        } else {
            return Result.error(cm);
        }
    }
}
