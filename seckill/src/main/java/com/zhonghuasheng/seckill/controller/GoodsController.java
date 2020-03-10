package com.zhonghuasheng.seckill.controller;

import com.zhonghuasheng.seckill.domain.SecKillUser;
import com.zhonghuasheng.seckill.redis.SeckillUserKey;
import com.zhonghuasheng.seckill.service.GoodsService;
import com.zhonghuasheng.seckill.service.SeckillUserService;
import com.zhonghuasheng.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    @RequestMapping("/detail/{id}")
    public String detail(Model model, SecKillUser user, @PathVariable("id") long id) {
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.getById(id);
        model.addAttribute("goods", goods);

        long startTime = goods.getStartDate().getTime();
        long endTime = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();

        int seckillStatus = 0;
        int remainSeconds = 0;

        if ( now < startTime ) {
            seckillStatus = 0;
            remainSeconds = (int) ((startTime - now) / 1000);
        } else if (now > endTime) {
            seckillStatus = 2;
            remainSeconds = -1;
        } else {
            seckillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("seckillStatus", seckillStatus);
        model.addAttribute("remainSeconds", remainSeconds);

        return "goods_detail";
    }
}
