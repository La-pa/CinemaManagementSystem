package com.example.backend;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.controller.Code;
import com.example.backend.controller.IndentController;
import com.example.backend.controller.Result;
import com.example.backend.entity.Indent;
import com.example.backend.entity.Seat;
import com.example.backend.entity.Ticket;
import com.example.backend.exception.BusinessException;
import com.example.backend.mapper.IndentMapper;
import com.example.backend.service.IndentService;
import com.example.backend.service.SeatService;
import com.example.backend.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BackEndApplicationTest {


    @Autowired
    private IndentService indentService;
//    @Test
//    public void testTicketGetBySessionId() {
//        List<Indent> indents = indentService.getByUserId(1);
//        for (Indent indent : indents) {
////            Timestamp timestamp =
//            System.out.println(indent);
//        }
//    }
}
