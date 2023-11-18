package com.zhonghuasheng.springboot.aspect;

import com.zhonghuasheng.springboot.aspect.annotation.UserAccess;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // Order能指定切面执行的顺序，值越小越先执行
public class UserAccessAspect {

    @Pointcut(value = "@annotation(com.zhonghuasheng.springboot.aspect.annotation.UserAccess)")
    public void access() {};

    @Before("access()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("second before");
    }

    @Around("@annotation(userAccess)")
    public Object around(ProceedingJoinPoint joinPoint, UserAccess userAccess) {
        System.out.println("获取直接中的值： " + userAccess.desc());
        try {
            Object object = joinPoint.proceed();

            return object;
        } catch (Throwable throwable) {
            throwable.printStackTrace();

            return null;
        }
    }
}
