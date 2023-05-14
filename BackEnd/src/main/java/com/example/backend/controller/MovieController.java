package com.example.backend.controller;

import com.example.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public Result findAll() {
        return new Result(Code.QUERY_SUCCESS, movieService.list(),"查询成功");
    }

}
