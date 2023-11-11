package com.zhonghuasheng.ioc.annotation.repeatable;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Values.class)
public @interface Value {
    String value() default "";
}
