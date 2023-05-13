package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Session;
import com.example.backend.service.SessionService;
import com.example.backend.mapper.SessionMapper;
import org.springframework.stereotype.Service;

/**
* @author Jiang
* @description 针对表【session】的数据库操作Service实现
* @createDate 2023-05-13 14:04:01
*/
@Service
public class SessionServiceImpl extends ServiceImpl<SessionMapper, Session>
    implements SessionService{

}




