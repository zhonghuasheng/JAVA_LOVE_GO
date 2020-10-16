package com.zhonghuasheng.ioc.annotation.documented;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyDocumented {

    String value() default "Documented注解";
}
