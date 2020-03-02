package com.zhonghuasheng.springmvc.controller;

import com.zhonghuasheng.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * @RequestBody注解会将返回值放入requstBody中返回
     * @param request
     * @return
     */
    @RequestMapping
    public @ResponseBody String index(HttpServletRequest request) {
        return "url: " + request.getRequestURL();
    }

    // http://localhost:8080/user/pathvar/sdfadsf
    @RequestMapping(value = "/pathvar/{str}")
    public @ResponseBody String pathVar(@PathVariable String str, HttpServletRequest request) {
        return "url: " + request.getRequestURL() + "str: " + str;
    }

    // http://localhost:8080/user/requestParam?id=12
    @RequestMapping(value = "/requestParam")
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
        return "url: " + request.getRequestURL() + "id: " + id;
    }

    // http://localhost:8080/user/obj?age=1&name=xx
    @RequestMapping(value = "/obj")
    @ResponseBody
    public String passObj(User user, HttpServletRequest request) {
        return "url: " + request.getRequestURL() + " user： " + user.toString();
    }

    // http://localhost:8080/user/path1  http://localhost:8080/user/path2
    @RequestMapping(value = {"/path1", "/path2"})
    @ResponseBody
    public String multiplePath(HttpServletRequest request) {
        return "url: " + request.getRequestURL();
    }

    // @RequestBody注解用于读取http请求的内容(字符串)，通过springmvc提供的HttpMessageConverter接口将读到的内容（json数据）
    // 转换为java对象并绑定到Controller方法的参数上。
    @PostMapping("/add")
    @ResponseBody
    public User add(@RequestBody User user) {
        return user;
    }
}
