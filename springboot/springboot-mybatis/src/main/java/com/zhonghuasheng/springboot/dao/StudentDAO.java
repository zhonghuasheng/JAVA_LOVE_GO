package com.zhonghuasheng.springboot.dao;

import com.zhonghuasheng.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;

// 这里加@Mapper就不需要配置扫描地址，如果用@Repository来注解，需要配置扫描地址
@Mapper
public interface StudentDAO {

    Student select(long id);
}
