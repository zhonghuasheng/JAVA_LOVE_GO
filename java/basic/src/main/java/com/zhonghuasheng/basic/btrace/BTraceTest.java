/*
package com.zhonghuasheng.basic.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class BTraceTest {

    @OnMethod(
            clazz = "com.zhonghuasheng.basic.btrace.Calculator",
            method = "add",
            location = @Location(Kind.RETURN)
    )
    public static void testBTrace(double x, double y, @Return double sum) {
        BTraceUtils.println("x: " + x + " y: " + y);
        BTraceUtils.println("sum: " + (x + y));
    }
}
*/
