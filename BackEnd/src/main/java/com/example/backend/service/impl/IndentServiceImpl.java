package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Indent;
import com.example.backend.mapper.IndentMapper;
import com.example.backend.service.IndentService;
import org.springframework.stereotype.Service;

/**
* @author Jiang
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-05-13 14:04:01
*/
@Service
public class IndentServiceImpl extends ServiceImpl<IndentMapper, Indent>
    implements IndentService {

    @Override
    public Indent getByUserId(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("userId", userId.toString());
        return this.getOne(queryWrapper);
    }
}




