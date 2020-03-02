package com.zhonghuasheng.spring4.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.zhonghuasheng.spring4.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
