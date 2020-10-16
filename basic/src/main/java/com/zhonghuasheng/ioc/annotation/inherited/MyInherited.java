package com.zhonghuasheng.ioc.annotation.inherited;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyInherited {
}
