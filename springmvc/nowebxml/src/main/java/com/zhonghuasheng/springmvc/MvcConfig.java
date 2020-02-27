package com.zhonghuasheng.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.zhonghuasheng.springmvc")
public class MvcConfig extends WebMvcConfigurerAdapter {

    // 视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/"); // 指定页面位置，该位置为编译后的位置，参考SpringBoot
        viewResolver.setSuffix(".jsp"); // 指定页面后缀
        viewResolver.setViewClass(JstlView.class); // 指定解析视图的类

        return viewResolver;
    }
}
