package com.zhonghuasheng.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁止隧道 / 禁止跨域 / 禁止头部
        http.csrf().disable().cors().disable().headers().disable();
        // 所有人都可以访问的路径
        http.authorizeRequests().antMatchers("/").permitAll();
    }
}
