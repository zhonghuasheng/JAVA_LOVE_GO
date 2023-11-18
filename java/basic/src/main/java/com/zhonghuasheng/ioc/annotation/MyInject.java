package com.zhonghuasheng.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention( RetentionPolicy.RUNTIME )
public @interface MyInject {
    // 被@MyInject注解注释的属性都会自动注入，实现IOC功能
}
