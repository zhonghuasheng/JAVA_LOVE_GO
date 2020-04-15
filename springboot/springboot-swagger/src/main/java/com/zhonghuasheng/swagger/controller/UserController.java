package com.zhonghuasheng.swagger.controller;

import com.zhonghuasheng.swagger.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return null;
    }


}
