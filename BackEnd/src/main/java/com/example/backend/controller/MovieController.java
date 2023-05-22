package com.example.backend.controller;

import com.example.backend.entity.Movie;
import com.example.backend.exception.SystemException;
import com.example.backend.service.MovieService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("电影信息")
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     * 查找出最近上映的10部电影
     * @return
     */
    @ApiOperation("查看最近发布的前10部影片")
    @GetMapping
    public Result<Movie> findAll() {
        return new Result(20000, movieService.findAll(),"查询成功");
    }


    @ApiOperation("查看电影的详情")
    @ApiResponses(@ApiResponse(code = 30000, message = "查询成功", response = Movie.class))
    @GetMapping("/{id}")
    public Result<Movie> getById(@ApiParam(name = "电影ID") @PathVariable Integer id) {
        return new Result(Code.SUCCESS, movieService.getById(id), "查询成功");
    }

}
