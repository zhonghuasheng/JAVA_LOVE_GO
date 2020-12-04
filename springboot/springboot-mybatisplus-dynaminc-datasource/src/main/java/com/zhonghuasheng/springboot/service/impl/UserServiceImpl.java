package com.zhonghuasheng.springboot.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhonghuasheng.springboot.mapper.UserMapper;
import com.zhonghuasheng.springboot.model.User;
import com.zhonghuasheng.springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @DS("slave_1")
    @Override
    public User getUserByPhone(String phone) {
            return baseMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getPhone, phone).last("LIMIT 1"));
    }

    @Override
    public boolean saveUser(User user) {
        return baseMapper.insert(user) > 0;
    }
}
