package com.zhonghuasheng.springboot.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_test")
public class User {

    private String nickname;
    private String phone;
}
