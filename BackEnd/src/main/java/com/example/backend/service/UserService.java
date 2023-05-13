package com.example.backend.service;

import com.example.backend.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author Jiang
* @description 针对表【user】的数据库操作Service
* @createDate 2023-05-13 14:04:01
*/
@Service
public interface UserService extends IService<User> {
//    public User getById(Integer id);
//    public boolean save(User user);
}
