package com.zhonghuasheng.mybatisplus.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
public class SuperEntity<T extends Model> extends Model<T> {
}
