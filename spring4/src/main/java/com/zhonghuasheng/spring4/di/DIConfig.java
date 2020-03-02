package com.zhonghuasheng.spring4.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ①@Configuration声明当前类是一个配置类。
 * ②使用@ComponentScan注解将会自动扫描包名下所有使用@Service,
 * @Component,@Repository和@Controller的类，并注册为Bean。
 */
@Configuration
@ComponentScan("com.zhonghuasheng.spring4.di")
public class DIConfig {
}
