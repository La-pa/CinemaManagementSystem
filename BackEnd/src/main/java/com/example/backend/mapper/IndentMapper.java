package com.example.backend.mapper;

import com.example.backend.entity.Indent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;

import java.util.List;

/**
* @author Jiang
* @description 针对表【indent】的数据库操作Mapper
* @createDate 2023-05-17 21:09:08
* @Entity com.example.backend.entity.Indent
*/
public interface IndentMapper extends BaseMapper<Indent> {

    List<Indent> getByUserId(Long userId);
}




