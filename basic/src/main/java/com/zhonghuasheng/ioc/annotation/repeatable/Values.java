package com.zhonghuasheng.ioc.annotation.repeatable;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Values {
    Value[] value();
}
