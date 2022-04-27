package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
            @ApiImplicitParam(name = "tel", value = "用户的唯一标识", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String")
    })

    @PostMapping("/insert")
    public void insert(String tel, String name,String password) {
        userService.insertUser(new User(tel,name,password));
    }

    @ApiOperation(value = "修改用户密码", notes = "通过tel修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tel", value = "用户的唯一标识", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String")
    })
    @PostMapping("/update")
    public void updatePassword( String tel,String password) {
        userService.updatePassword(tel,password);
    }

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @GetMapping("/all")
    public List<User> all() {
        return userService.findAll();
    }


    @ApiOperation(value = "删除用户信息", notes = "通过tel删除用户")
    @DeleteMapping("/{tel}")
    public int  deleteById(@PathVariable String tel) {
       return userService.deleteUser(tel);
    }


}
