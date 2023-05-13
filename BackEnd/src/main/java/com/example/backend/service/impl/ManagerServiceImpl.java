package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Manager;
import com.example.backend.service.ManagerService;
import com.example.backend.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

/**
* @author Jiang
* @description 针对表【manager】的数据库操作Service实现
* @createDate 2023-05-13 14:04:01
*/
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager>
    implements ManagerService{

}




