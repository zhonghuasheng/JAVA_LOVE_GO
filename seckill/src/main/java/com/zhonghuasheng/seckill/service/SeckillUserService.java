package com.zhonghuasheng.seckill.service;

import com.zhonghuasheng.seckill.common.CodeMsg;
import com.zhonghuasheng.seckill.dao.SecKillUserDao;
import com.zhonghuasheng.seckill.domain.SecKillUser;
import com.zhonghuasheng.seckill.util.MD5Util;
import com.zhonghuasheng.seckill.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillUserService {

    @Autowired
    SecKillUserDao secKillUserDao;

    public SecKillUser getById(long id) {
        return secKillUserDao.getById(id);
    }

    public CodeMsg login(LoginVo loginVo) {
        if (loginVo == null) {
            return CodeMsg.SESSION_ERROR;
        }
        // 判断手机号是否存在
        SecKillUser user = getById(Long.parseLong(loginVo.getMobile()));
        if (user == null) {
            return CodeMsg.MOBILE_NOT_EXIST;
        }
        // 验证密码
        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();
        String formPass2DbPass = MD5Util.formPass2DbPass(loginVo.getPassword(), dbSalt);
        if (!formPass2DbPass.equals(dbPass)) {
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;

    }
}
