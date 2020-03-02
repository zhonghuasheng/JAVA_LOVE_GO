package com.zhonghuasheng.spring4.light4j;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
@ComponentScan
public @interface Light4jConfiguration {
}
