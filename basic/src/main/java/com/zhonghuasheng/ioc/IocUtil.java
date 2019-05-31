package com.zhonghuasheng.ioc;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import com.zhonghuasheng.ioc.annotation.MyInject;

public class IocUtil {

    public static void inject() {
        // 为被@Inject注解的变量注入value
        Map<Class<?>, Object> map = IocContext.APPLICATIONCONTEXT_MAP;
        for (Entry<Class<?>, Object> entry : map.entrySet()) {
            Class<?> clazz = entry.getKey();
            Object object = entry.getValue();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MyInject.class)) {
                    Class<?> fieldClazz = field.getType();
                    field.setAccessible(true);
                    Object fieldObject = map.get(fieldClazz);
                    try {
                        field.set(object, fieldObject);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
