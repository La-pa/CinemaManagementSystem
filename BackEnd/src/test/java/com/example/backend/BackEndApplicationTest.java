package com.example.backend;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.controller.Code;
import com.example.backend.controller.Result;
import com.example.backend.entity.Indent;
import com.example.backend.entity.Seat;
import com.example.backend.entity.Ticket;
import com.example.backend.exception.BusinessException;
import com.example.backend.mapper.IndentMapper;
import com.example.backend.service.SeatService;
import com.example.backend.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BackEndApplicationTest {


    @Autowired
    private TicketService ticketService;
//    @Test
//    public void testTicketGetBySessionId() {
//        Ticket ticket = new Ticket();
//        ticket.setSessionId(3);
//        ticket.setSeatId(1);
//        LambdaQueryWrapper<Ticket> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Ticket::getSessionId, ticket.getSessionId())
//                .eq(Ticket::getSeatId, ticket.getSeatId());
//        List<Ticket> tickets = ticketService.list(wrapper);
//        System.out.println(tickets);
//
//    }
}
