package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.entity.Indent;
import com.example.backend.entity.Movie;
import com.example.backend.entity.Ticket;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.IndentService;
import com.example.backend.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Api(tags = "订单信息")
@RestController
@RequestMapping("/indents")
public class IndentController {
    @Autowired
    private IndentService indentService;

    @Autowired
    private TicketService ticketService;


    @ApiOperation("查看当前用户的订单")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在"),
            @ApiResponse(code = 60011, message = "用户未登入")})
    @GetMapping
    public Result<Indent> findAll(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_USER_NOT_LOGIN, "用户未登入");
        }
        List<Indent> indents = indentService.getByUserId(userId);
        if (indents == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        } else {
            return Result.success(indents);
        }
    }


    @ApiOperation("删除订单")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteIndent(@PathVariable Long id) {
        Indent indent = indentService.getById(id);
        if (indentService.deleteById(id)) {
            return Result.success();
        } else {
            throw  new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        }
    }



    @ApiOperation("添加订单")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在"),
            @ApiResponse(code = 60011, message = "用户未登入"),
            @ApiResponse(code = 20022, message = "数据插入失败")})
    @PostMapping
    public Result insertIndent(@RequestBody Ticket ticket, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_USER_NOT_LOGIN, "用户未登入");
        }
        LambdaQueryWrapper<Ticket> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Ticket::getSessionId, ticket.getSessionId())
                .eq(Ticket::getSeatId, ticket.getSeatId());
        if (ticketService.list(wrapper).isEmpty() == false) {
            throw new BusinessException(Code.INSERT_ERROR, "数据已经存在");
        }
        if (ticketService.save(ticket) == false) {
            throw new BusinessException(Code.INSERT_ERROR, "数据插入失败");
        }
        Indent indent = new Indent(LocalDateTime.now(), ticket.getId(), ticket, userId);
        if (indentService.save(indent)) {
            return Result.success();
        } else {
            throw new BusinessException(Code.INSERT_ERROR, "数据插入失败");
        }
    }
}
