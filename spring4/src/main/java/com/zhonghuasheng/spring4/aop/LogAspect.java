package com.zhonghuasheng.spring4.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.zhonghuasheng.spring4.aop.Action)")
    public void annotationPointCut(){};

    /**
     * 注解拦截
     * @param joinPoint
     */
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("AnnotationPointCut执行之后" + action.name());
    }

    @Before("annotationPointCut()")
    public void before1(JoinPoint joinPoint) {
        System.out.println("AnnotationPointCut执行之前");
    }

    /**
     * 方法拦截
     * @param joinPoint
     */
    @Before("execution(* com.zhonghuasheng.spring4.aop.NoAnnotationUserService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("可以在这个方法执行之前做些什么" + method.getName());
    }
}
