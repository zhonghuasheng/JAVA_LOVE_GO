package com.zhonghuasheng.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler(MyException.class)
    public String handleMyException(Exception ex) {
        log.error("处理自定义异常");

        return "error/myexception";
    }
}
