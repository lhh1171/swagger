package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name =#{name}")
    User findByName(@Param("name") String name);

    @Results({
            @Result(property = "uid", column = "uid"),
            @Result(property = "name", column = "name"),
            @Result(property = "did", column = "did"),
            @Result(property = "password", column = "password")
    })

    @Select("SELECT uid,name,did,password FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user(uid,name,did,password) VALUES(#{uid}, #{name},#{did},#{password})")
    int insert(@Param("uid") String uid, @Param("name") String name, @Param("did") String did,@Param("password") String password);

    @Delete("DELETE FROM user WHERE uid =#{uid}")
    int delete(String uid);
}
