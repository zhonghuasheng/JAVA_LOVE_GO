package com.zhonghuasheng.spring4.di;

import org.springframework.stereotype.Service;

/**
 * 使用@Service注解声明当前FunctionService类是Spring容器管理的一个Bean。
 * 其中，使用@Component,@Service,@Repository和@Controller是等效的，可以根据自己的需要选用。
 */
@Service
public class FunctionService {

    public void say(String str) {
        System.out.println("Hello " + str);
    }
}
