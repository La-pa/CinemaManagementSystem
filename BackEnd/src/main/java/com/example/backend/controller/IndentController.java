package com.example.backend.controller;

import com.example.backend.entity.Indent;
import com.example.backend.entity.Ticket;
import com.example.backend.service.IndentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


@RestController
@Api(value = "订单接口")
@RequestMapping("/indents")
public class IndentController {
    @Autowired
    private IndentService indentService;


    @ApiOperation("查看当前用户的订单")

    @GetMapping
    public Result findAll(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer useId = (Integer) session.getAttribute("userId");

        if (useId == null) {
            return new Result(Code.QUERY_ERROR, "用户未登录");
        }

        Object data = indentService.getByUserId(useId);
        if (data == null) {
            return new Result(Code.QUERY_SUCCESS, "未查询到数据");
        } else {
            return new Result(Code.QUERY_SUCCESS, data, "查询成功");
        }
    }


    @ApiOperation("删除订单")

    @DeleteMapping("/{id}")
    public Result deleteIndent(@PathVariable Integer id) {
        Indent indent = indentService.getById(id);
        if (indent == null) {
            return new Result(Code.DELETE_ERROR, "未找到该订单");
        }

        boolean flag = indentService.deleteById(id);
        if (flag) {
            return new Result(Code.DELETE_SUCCESS, true,"订单删除成功");
        } else {
            return new Result(Code.DELETE_ERROR, false,"订单删除失败");
        }
    }



    @ApiOperation("添加订单")

    @PostMapping
    public Result insertIndent(@RequestBody Ticket ticket, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        Indent indent = new Indent(new Date(), ticket.getId(), ticket, userId);
        return new Result(Code.INSERT_SUCCESS, indentService.addDate(indent), "订单添加成功");
    }
}
