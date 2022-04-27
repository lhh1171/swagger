package com.example.demo.service;



import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int deleteUser(String tel) {
        return userMapper.delete(tel);
    }

    public void insertUser(User user) {
        userMapper.insert(user.getTel(), user.getName(), user.getPassword());
    }


    public void findByName(String name){
        userMapper.findByName(name);
    }

    public List<User> findAll(){
        return  userMapper.findAll();
    }
    public void updatePassword(String tel,String password){
        userMapper.updatePassword(tel,password);
    }
}
