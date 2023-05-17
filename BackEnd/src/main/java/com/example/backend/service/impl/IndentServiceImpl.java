package com.example.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.entity.Indent;
import com.example.backend.entity.Ticket;
import com.example.backend.mapper.IndentMapper;
import com.example.backend.mapper.TicketMapper;
import com.example.backend.service.IndentService;
import com.example.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Jiang
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-05-13 14:04:01
*/
@Service
public class IndentServiceImpl extends ServiceImpl<IndentMapper, Indent>
    implements IndentService {

    @Autowired
    IndentMapper indentMapper;

    @Autowired
    TicketService ticketService;

    @Override
    public List<Indent> getByUserId(Integer userId) {
        return indentMapper.getByUserId(userId);
    }

    public boolean deleteById(Integer id) {
        Indent indent = this.getById(id);
        Long ticketId = indent.getTicketId();
        boolean i = ticketService.removeById(ticketId);
        if (i == false) return false;
        boolean b = this.removeById(id);
        return b;
    }

    @Override
    public boolean addDate(Indent indent) {
        Ticket ticket = indent.getTicket();
        boolean i = ticketService.save(ticket);
        if (i == false) {
            return false;
        }
        boolean b = this.save(indent);
        return b;
    }
}




