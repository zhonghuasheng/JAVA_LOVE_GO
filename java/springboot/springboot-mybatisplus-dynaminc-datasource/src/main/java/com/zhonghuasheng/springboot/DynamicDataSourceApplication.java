package com.zhonghuasheng.springboot;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class DynamicDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDataSourceApplication.class, args);
    }
}
/**
 * 本项目是实现springboot + mybatis-plus dynamic datasource动态数据源，写完之后呢，我想把数据库连接池加上，因此就上了阿里的druid
 * 在上druid的过程中，出现了DS与Druid中都会自动配置数据库的url等信息，导致springboot不知道选哪个，因此报错
 * 监控界面 http://localhost:8080/druid/login.html
 */
