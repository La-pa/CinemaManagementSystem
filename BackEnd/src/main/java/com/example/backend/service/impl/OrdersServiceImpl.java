package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Orders;
import com.example.backend.service.OrdersService;
import com.example.backend.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author Jiang
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-05-13 14:04:01
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




