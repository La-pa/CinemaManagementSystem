package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.entity.Seat;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.SeatService;
import io.swagger.annotations.*;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "座位信息")
@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @ApiOperation("查询放映厅座位分布情况")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping("/{roomId}")
    public Result<Seat> findByRoomId(@PathVariable Integer roomId) {
        LambdaQueryWrapper<Seat> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Seat::getRoomId, roomId);
        List<Seat> seats = seatService.list(queryWrapper);
        if (seats == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        } else {
            return Result.success(seats);
        }
    }

    @ApiOperation("查询所有座位")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping
    public Result<Seat> findAll() {
        List<Seat> seats = seatService.list();
        if (seats == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        } else {
            return Result.success(seats);
        }
    }
}
