package com.zhonghuasheng.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhonghuasheng.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
