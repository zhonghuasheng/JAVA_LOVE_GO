package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.domain.SecKillUser;
import com.zhonghuasheng.seckill.redis.SeckillUserKey;
import com.zhonghuasheng.seckill.service.GoodsService;
import com.zhonghuasheng.seckill.service.SeckillUserService;
import com.zhonghuasheng.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    // 商品列表
    @RequestMapping("/")
    public String list(Model model, SecKillUser user) {
        model.addAttribute("user", user);
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }

    // 商品详情
    public String detail() {
        return null;
    }
}
