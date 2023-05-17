package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.entity.Seat;
import com.example.backend.entity.Session;
import com.example.backend.entity.Ticket;
import com.example.backend.service.SeatService;
import com.example.backend.service.SessionService;
import com.example.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeatService seatService;

    // TODO 感觉要删除电影票中的用户属性

    /**
     * 查询该场次已购买的座位
     * @param sessionId
     * @return
     */
    @GetMapping("/{sessionId}")
    public Result findBySessionId(@PathVariable Integer sessionId) {
        LambdaQueryWrapper<Ticket> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Ticket::getSessionId, sessionId);
        List<Ticket> tickets = ticketService.list(wrapper);
        List<Seat> seats = null;
        for (Ticket ticket: tickets) {
            Seat seat = seatService.getById(ticket.getSeatId());
            seats.add(seat);
        }
        return new Result(Code.QUERY_SUCCESS, seats, "座位查询成功");
    }

}
