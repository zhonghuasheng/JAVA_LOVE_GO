package com.zhonghuasheng.basic.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.omg.Dynamic.Parameter;

public class ClassUtil {

    public static void showClassInfo(Class c) {
        System.out.println("Class Name: " + c.getName());
        System.out.println("Class simple name: " + c.getSimpleName());
    }

    public static void showConstructorInfo(Class c) {
        Constructor[] constructors = c.getConstructors();

        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];
            System.out.print(constructor.getName() + "(");

            Class[] parameterTypes = constructor.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                Class<? extends Object> parameterC = parameterTypes[j];
                System.out.print(parameterC.getSimpleName());

                if (j < parameterTypes.length -1) {
                    System.out.print(", ");
                }
            }

            System.out.println(")");
        }
    }

    public static void showMethodsInfo(Class c) {
        Method[] methods = c.getMethods();

        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];

            Class returnType = method.getReturnType();

            String accessible = method.isAccessible() ? "public" : "private";

            System.out.print(accessible + " " + method.getName() + " " + returnType.getName() + "(");
        }
    }
}
