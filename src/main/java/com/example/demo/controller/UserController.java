package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "用户模块")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户的唯一标识", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "did", value = "用户基本信息表ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String")
    })
    @PostMapping
    public void insert(String uid, String name,String did,String password) {
        userService.insertUser(new User(uid,name,did,password));
    }


    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @GetMapping("/all")
    public List<User> all() {
        return userService.findAll();
    }


    @ApiOperation(value = "删除用户信息", notes = "通过id删除用户")
    @DeleteMapping("/{id}")
    public int  deleteById(@PathVariable String id) {
       return userService.deleteUser(id);
    }

}
