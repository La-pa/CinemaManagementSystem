package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.entity.Session;
import com.example.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;


    /**
     * 根据电影查询场次
     * @param
     * @return
     */
    @GetMapping("/{movieId}")
    public Result findById(@PathVariable Integer movieId) {
        LambdaQueryWrapper<Session> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Session::getMovieId, movieId);
        return new Result(Code.QUERY_SUCCESS, sessionService.list(wrapper), "场次查询成功");
    }

}
