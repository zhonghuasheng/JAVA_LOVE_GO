package com.zhonghuasheng.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE})
@Retention( RetentionPolicy.RUNTIME )
public @interface MyComponent {
    // 只要被@MyComponent自定义注解的类都受到容器管理的Bean
}
