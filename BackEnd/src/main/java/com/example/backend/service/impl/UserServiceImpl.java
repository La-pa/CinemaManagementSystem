package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.assist.ISqlRunner;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.config.SpringBootConfig;
import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import com.example.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Jiang
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-05-13 14:04:01
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
//    @Autowired
//    private UserMapper userMapper;
//    @Override
//    public User getById(Integer id) {
//        User user = userMapper.selectOne(new QueryWrapper<User>()
//                .select("id, password")
//                .eq("id", id));
//        return user;
//    }

//    @Override
//    public boolean save(User user) {
//        int insert = userMapper.insert(user);
//    }
}




