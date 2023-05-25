package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.entity.Seat;
import com.example.backend.entity.Ticket;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.SeatService;
import com.example.backend.service.SessionService;
import com.example.backend.service.TicketService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Api(tags = "电影票信息")
@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private SessionService sessionService;

    @ApiOperation("查询该场次已购买的座位")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping("/sessionId/{sessionId}")
    public Result<Seat> findBySessionId(@ApiParam(name = "sessionId", value = "场次id")@PathVariable Integer sessionId) {
        LambdaQueryWrapper<Ticket> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Ticket::getSessionId, sessionId);
        List<Ticket> tickets = ticketService.list(wrapper);
        List<Seat> seats = new ArrayList<>();
        for (Ticket ticket: tickets) {
            Seat seat = seatService.getById(ticket.getSeatId());
            seats.add(seat);
        }
        if (seats == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        }
        return Result.success(seats);
    }

    @ApiOperation("根据电影票ID查询电影票信息")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping("/{id}")
    public Result<Seat> findById(@ApiParam(name = "id", value = "电影票id")@PathVariable Integer id) {
        Ticket ticket = ticketService.getById(id);
        if (ticket == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        }
        ticket.setSession(sessionService.getById(ticket.getSessionId()));
        ticket.setSeat(seatService.getById(ticket.getSeatId()));
        return Result.success(ticket);
    }

}
