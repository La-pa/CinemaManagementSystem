package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.entity.Indent;
import com.example.backend.entity.Room;
import com.example.backend.entity.Session;
import com.example.backend.service.RoomService;
import com.example.backend.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;


    @ApiOperation("查询放映厅名字")

    @GetMapping("/{id}")
    public Result<Room> findById(@ApiParam("放映厅ID") @PathVariable Integer id) {
        return new Result(Code.QUERY_SUCCESS, roomService.getById(id), "放映厅查询成功");
    }

}
