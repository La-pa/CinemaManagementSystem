package com.example.backend;

import com.example.backend.entity.Indent;
import com.example.backend.entity.User;
import com.example.backend.mapper.IndentMapper;
import com.example.backend.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BackEndApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IndentMapper indentMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        System.out.println("hell world");
    }

    @Test
    void testIndentFindAll() {
        List<Indent> indents = indentMapper.getByUserId(1);
        for (Indent indent: indents) {
            System.out.println(indent);
        }
    }
}
