package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.entity.Session;
import com.example.backend.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "场次信息")
@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;


    @ApiOperation("根据电影查询场次")
    @GetMapping("/{movieId}")
    public Result<Session> findById(@ApiParam(name = "movieId", value = "电影Id")@PathVariable Integer movieId) {
        LambdaQueryWrapper<Session> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Session::getMovieId, movieId);
        return new Result(Code.SUCCESS, sessionService.list(wrapper), "场次查询成功");
    }

}
