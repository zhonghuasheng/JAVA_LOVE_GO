package com.zhonghuasheng.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class MyExceptionControllerAdvice {

    public String handlerMyException(MyException  exception) {
        log.error("自定义Exception Handler Advice");

        return "error/myexception";
    }
}
