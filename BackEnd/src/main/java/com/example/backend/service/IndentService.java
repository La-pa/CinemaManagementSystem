package com.example.backend.service;

import com.example.backend.entity.Indent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Jiang
* @description 针对表【orders】的数据库操作Service
* @createDate 2023-05-13 14:04:01
*/
public interface IndentService extends IService<Indent> {
    public List<Indent> getByUserId(Integer userId);


}
