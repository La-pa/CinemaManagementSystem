package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Movie;
import com.example.backend.service.MovieService;
import com.example.backend.mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Jiang
* @description 针对表【movie】的数据库操作Service实现
* @createDate 2023-05-13 14:04:01
*/
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie>
    implements MovieService{
    @Override
    public List<Movie> findAll() {
        LambdaQueryWrapper<Movie> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Movie::getReleaseDate)
                .select(Movie::getId, Movie::getTitle, Movie::getImageUrl)
                .last("limit 10");
        List<Movie> movies = this.list(wrapper);
        return movies;
    }
}




