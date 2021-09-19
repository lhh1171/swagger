package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration  (classes = DemoApplication.class)
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        userService.insertUser(new User("6","6","2","2"));
        userService.findByName("6");
    }

}
