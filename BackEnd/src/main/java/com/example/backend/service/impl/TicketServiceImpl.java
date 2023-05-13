package com.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Ticket;
import com.example.backend.service.TicketService;
import com.example.backend.mapper.TicketMapper;
import org.springframework.stereotype.Service;

/**
* @author Jiang
* @description 针对表【ticket】的数据库操作Service实现
* @createDate 2023-05-13 14:04:01
*/
@Service
public class TicketServiceImpl extends ServiceImpl<TicketMapper, Ticket>
    implements TicketService{

}




