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
            @Result(property = "tel", column = "tel"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password")
    })

    @Select("SELECT tel,name,password FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user(tel,name,password) VALUES(#{tel}, #{name},#{password})")
    int insert(@Param("tel") String uid, @Param("name") String name,@Param("password") String password);

    @Delete("DELETE FROM user WHERE tel =#{tel}")
    int delete(String tel);

    @Update("UPDATE user SET password=#{password} where tel=#{tel}")
    int updatePassword(String tel,String password);

}
