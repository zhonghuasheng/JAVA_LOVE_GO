package com.zhonghuasheng.spring4.javaconfig;

public class UserFunctionService {

    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public void say(String str) {
        functionService.say(str);
    }
}
