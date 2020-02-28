package com.zhonghuasheng.springmvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    // 全局异常处理
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

    // 全局数据绑定
    @ModelAttribute(name = "globalData")
    public Map<String, Object> data() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Luke");
        map.put("age", "18");

        return map;
    }

    @ModelAttribute(name = "globalData2")
    public Map<String, Object> aData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Luke");
        map.put("age", "18");

        return map;
    }

    @ModelAttribute
    public void addModelAttribute(Model model) {
        model.addAttribute("msg", "Msg from ModelAttribute");
    }
}
