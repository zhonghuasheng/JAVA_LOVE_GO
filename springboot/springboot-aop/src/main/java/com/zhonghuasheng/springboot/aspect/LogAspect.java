package com.zhonghuasheng.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect // 作用是把当前类标识为一个切面供容器读取
@Component // 需要被标注为bean，在加载完前这些切面信息需要被容器知道
public class LogAspect {

    // 定义切点，切点方法不用任何代码，返回值是void，注意条件表达式
    @Pointcut("execution(public * com.zhonghuasheng.springboot.controller.*.*(..))")
    public void webLog() {}

    /** 标识一个前置增强方法，相当于BeforeAdvice功能
     * @Before("execution(public * com.zhonghuasheng.springboot.controller.*.*(..))")
     * 这两种写法是类似的效果，抽出来Pointcut会方便些
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收请求，注意这里使用的是RequestContextHolder
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    /**后置增强，相当于AfterReturningAdvice，方法退出时执行
     * returning是必须的，需要bound进去
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        System.out.println("方法返回值： " + ret);
    }

    /**
     * 异常通知。异常抛出时执行，相当于ThrowAdvice
     */
    @AfterThrowing(pointcut = "webLog()")
    public void afterThrown(JoinPoint joinPoint) {
        System.out.println("方法异常时执行");
    }

    /** final增强，不管是抛出异常还是正常退出都会执行
     */
    @After("webLog()")
    public void after(JoinPoint joinPoint) {
        System.out.println("最后执行的方法：不管是抛出异常还是正常退出，都会执行....");
    }

    /**
     * 环绕通知，在方法内部执行前后做处理，相当于MethodInterceptor
     */
    @Around("webLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("方法环绕开始");
        try {
            Object object = proceedingJoinPoint.proceed();
            System.out.println("方法环绕proceed,结果是： " + object);

            return object;
        } catch (Throwable throwable) {
            throwable.printStackTrace();

            return null;
        }
    }
}
