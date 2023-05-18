package com.example.backend.controller;

import com.example.backend.service.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     * 查找出最近上映的10部电影
     * @return
     */
    @GetMapping
    public Result findAll() {
        return new Result(Code.QUERY_SUCCESS, movieService.findAll(),"查询成功");
    }


    @ApiOperation("查看电影的详情")

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(Code.QUERY_SUCCESS, movieService.getById(id), "查询成功");
    }

}
