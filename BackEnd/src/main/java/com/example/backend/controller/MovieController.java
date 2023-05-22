package com.example.backend.controller;

import com.example.backend.entity.Movie;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.MovieService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "电影信息")
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @ApiOperation("查看最近发布的前10部影片")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping
    public Result<Movie> getAll() {
        List<Movie> movies = movieService.findAll();
        if (movies == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        }
        return Result.success(movies);
    }


    @ApiOperation("查看电影的详情")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping("/{id}")
    public Result<Movie> getById(@ApiParam(name = "id", value = "电影ID") @PathVariable Integer id) {
        Movie movie = movieService.getById(id);
        if (movie == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        }
        return Result.success(movie);
    }

}
