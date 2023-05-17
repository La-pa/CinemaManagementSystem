package com.example.backend.service;

import com.example.backend.entity.Movie;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Jiang
* @description 针对表【movie】的数据库操作Service
* @createDate 2023-05-13 14:04:01
*/
public interface MovieService extends IService<Movie> {
    public List<Movie> findAll();
}
