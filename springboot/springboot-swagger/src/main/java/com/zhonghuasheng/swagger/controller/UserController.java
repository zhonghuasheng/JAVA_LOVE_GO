package com.zhonghuasheng.swagger.controller;

import com.zhonghuasheng.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "UserController", tags = {"用户操作接口"})
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return null;
    }

    @ApiOperation(value = "删除用户", notes = "软删除")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        return "success";
    }

    @ApiOperation(value = "更新用户", notes = "根据url中的id来指定更新的用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user) {
        return null;
    }

    @ApiOperation(value = "获取用户", notes = "根据url中的id获取用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        return null;
    }

    @ApiOperation(value = "用户列表", notes = "用户列表")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return null;
    }
}
