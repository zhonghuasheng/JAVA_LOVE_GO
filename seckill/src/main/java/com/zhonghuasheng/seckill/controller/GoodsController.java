package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.domain.SecKillUser;
import com.zhonghuasheng.seckill.redis.SeckillUserKey;
import com.zhonghuasheng.seckill.service.SeckillUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    SeckillUserService userService;

    @RequestMapping("/")
    public String list(Model model, HttpServletResponse response,
                       @CookieValue(value = SeckillUserService.COOKIE_NAME_TOKEN, required = false) String coolieToken,
                       @RequestParam(value = SeckillUserService.COOKIE_NAME_TOKEN, required = false) String paramToken) {
        if (StringUtils.isEmpty(coolieToken) && StringUtils.isEmpty(paramToken)) {
            return "login";
        }
        String token = StringUtils.isEmpty(paramToken) ? coolieToken : paramToken;
        SecKillUser user = userService.getByToken(response, token);
        model.addAttribute("user", user);

        return "goods_list";
    }
}
