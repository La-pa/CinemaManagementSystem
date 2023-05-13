package com.example.backend;

import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BackEndApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        System.out.println("hell world");
    }

}
