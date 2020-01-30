/*
package com.zhonghuasheng.basic.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;

@BTrace
public class BTraceTestForHashMap {

    @OnMethod(
            clazz = "java.util.HashMap",
            method = "createEntry",
            location = @Location(Kind.ENTRY)
    )
    public static void testBTrace(int hash, Object key, Object value, int bucketIndex) {
        BTraceUtils.print(" ::hash:: " + hash);
        BTraceUtils.print(" ::key:: " + key);
        BTraceUtils.print(" ::value:: " + value);
        BTraceUtils.println(" ::bucketIndex:: " + bucketIndex);
    }
}
*/
