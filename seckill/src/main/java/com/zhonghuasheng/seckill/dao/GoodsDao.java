package com.zhonghuasheng.seckill.dao;

import com.zhonghuasheng.seckill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("SELECT g.*, s.seckill_price, s.stock_count, s.start_date, s.end_date FROM goods AS g LEFT JOIN seckill_goods AS s ON g.id = s.id")
    List<GoodsVo> listGoodsVo();
}
