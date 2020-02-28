package com.zhonghuasheng.springmvc.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(Exception exception, WebRequest request) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorMessage", exception.getMessage());

        return mv;
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ModelAndView exceptionHandler(IllegalArgumentException exception) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorMessage", exception.getMessage());

        return mv;
    }
}
