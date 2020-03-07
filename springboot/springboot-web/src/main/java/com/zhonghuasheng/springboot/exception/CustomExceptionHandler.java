package com.zhonghuasheng.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 方式一：实现HandlerExceptionResolver接口
 * 实现该接口，注册到spring容器中，当controller中产生异常的时候会调用该接口来处理，
 * 注意，当返回值指定视图时会自动跳转至指定的视图中去，如果返回null，会继续调用下一
 * 个异常处理器去执行。  springboot中可以通过以下方式去注册进容器。
 */
@Slf4j
@Component
public class CustomExceptionHandler implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.error("错误信息：" + ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/500");

        return modelAndView;
    }
}
