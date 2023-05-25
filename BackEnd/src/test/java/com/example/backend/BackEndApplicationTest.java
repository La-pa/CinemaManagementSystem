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

    @Autowired
    private SeatService seatService;

    @Autowired
    private IndentMapper indentMapper;
//    @Test
//    public void testTicketGetBySessionId() {
//        int sessionId = 1;
//        LambdaQueryWrapper<Ticket> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Ticket::getSessionId, sessionId);
//        List<Ticket> tickets = ticketService.list(wrapper);
//        System.out.println(tickets);
//        List<Seat> seats = new ArrayList<Seat>();
//        for (Ticket ticket: tickets) {
//            Seat seat = seatService.getById(ticket.getSeatId());
//            System.out.println(seat);
//            seats.add(seat);
//        }
//        System.out.println(seats);
//    }
}
