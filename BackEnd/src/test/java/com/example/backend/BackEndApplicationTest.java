package com.example.backend;

import com.example.backend.entity.Indent;
import com.example.backend.mapper.IndentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BackEndApplicationTest {

    @Autowired
    private IndentMapper indentMapper;
//    @Test
//    public void testIndentGetByUserId() {
//        List<Indent> indents = indentMapper.getByUserId(1);
//        for (Indent indent : indents) {
//            System.out.println(indent);
//        }
//
//    }
}
