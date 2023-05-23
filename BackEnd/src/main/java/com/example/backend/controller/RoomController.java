package com.example.backend.controller;

import com.example.backend.entity.Room;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.RoomService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "放映厅信息")
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;


    @ApiOperation("查询放映厅名字")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping("/{id}")
    public Result<Room> findById(@ApiParam(name = "id", value = "放映厅ID") @PathVariable Integer id) {
        Room room = roomService.getById(id);
        if (room == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        } else {
            return Result.success(room);
        }
    }

    @ApiOperation("查询所有放映厅信息")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping
    public Result<Room> findAll() {
        List<Room> rooms = roomService.list();
        if (rooms == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        } else {
            return Result.success(rooms);
        }
    }

}
