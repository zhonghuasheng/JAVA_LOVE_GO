package com.zhonghuasheng.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("student")
public class Student extends SuperEntity {

    private long id;
    private String name;
    private int age;
}
