package com.example.demo.service;

import annotation.Cache;
import annotation.CacheDelete;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int deleteUser(String uid) {
        return userMapper.delete(uid);
    }

    @CacheDelete
    public int insertUser(User user) {
        return userMapper.insert(user.getUid(),user.getName(),user.getDid(),user.getPassword());
    }

    @Cache
    public User findByName(String name){
        return userMapper.findByName(name);
    }

    public List<User> findAll(){
        return  userMapper.findAll();
    }
}
