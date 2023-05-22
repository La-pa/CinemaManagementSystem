package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.entity.Seat;
import com.example.backend.entity.Ticket;
import com.example.backend.service.SeatService;
import com.example.backend.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "电影票信息")
@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeatService seatService;

    @ApiOperation("查询该场次已购买的座位")
    @GetMapping("/{sessionId}")
    public Result<Seat> findBySessionId(@ApiParam(name = "sessionId", value = "场次id")@PathVariable Integer sessionId) {
        LambdaQueryWrapper<Ticket> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Ticket::getSessionId, sessionId);
        List<Ticket> tickets = ticketService.list(wrapper);
        List<Seat> seats = null;
        for (Ticket ticket: tickets) {
            Seat seat = seatService.getById(ticket.getSeatId());
            seats.add(seat);
        }
        return new Result(Code.SUCCESS, seats, "座位查询成功");
    }

}
