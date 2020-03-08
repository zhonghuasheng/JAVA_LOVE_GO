package com.zhonghuasheng.seckill.common;

public class CodeMsg {

    private int code;
    private String msg;

    // 通用异常
    public static final CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static final CodeMsg SERVER_ERROR = new CodeMsg(0, "服务器异常");
    // 登陆模块5002XX
    public static final CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static final CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登陆密码不能为空");
    public static final CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static final CodeMsg MOBILE_FORMAT_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static final CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg(500214, "密码错误");
    //商品模块5003XX
    //订单模块5004XX
    //秒杀模块5005XX

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
