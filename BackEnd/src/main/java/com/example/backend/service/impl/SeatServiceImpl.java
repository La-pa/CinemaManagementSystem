package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Seat;
import com.example.backend.service.SeatService;
import com.example.backend.mapper.SeatMapper;
import org.springframework.stereotype.Service;

/**
* @author Jiang
* @description 针对表【seat】的数据库操作Service实现
* @createDate 2023-05-13 14:04:01
*/
@Service
public class SeatServiceImpl extends ServiceImpl<SeatMapper, Seat>
    implements SeatService{

}




