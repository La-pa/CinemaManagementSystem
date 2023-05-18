package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.entity.Seat;
import com.example.backend.service.SeatService;
import com.example.backend.service.SessionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @ApiOperation("查询放映厅座位分布情况")
    @GetMapping("/{id}")
    public Result findByRoomId(@PathVariable Integer roomId) {
        LambdaQueryWrapper<Seat> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Seat::getRoomId, roomId);
        List<Seat> seats = seatService.list(queryWrapper);
        return new Result(Code.QUERY_SUCCESS, seats, "放映厅座位查询成功");
    }
}