package com.example.backend.controller;

import com.example.backend.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class IndentController {
    @Autowired
    private IndentService indentService;

//    /**
//     * 查看当前用户的订单
//     * @param request
//     * @return Result
//     */
//    @GetMapping
//    public Result findAll(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        Integer useId = (Integer) session.getAttribute("userId");
//        Object data = ordersService.getByUserId(useId);
//        if (data == null) {
//            return new Result(Code.QUERY_SUCCESS,"未查询到数据");
//        } else {
//            return new Result(Code.QUERY_SUCCESS, data,"查询成功");
//        }
//    }
//
//    @DeleteMapping("#{id}")
//    public Result deleteOrder(@PathVariable Integer id) {
//        Order order = ordersService.getById(id);
//        if (order == null) {
//            return new Result(Code.DELETE_ERROR, "未找到该订单");
//        } else {
//            boolean flag = ordersService.removeById(id);
//            if (flag == true) {
//                return new Result(Code.DELETE_SUCCESS, "订单删除成功");
//            } else {
//                return new Result(Code.DELETE_ERROR, "系统出错");
//            }
//        }
//    }
}
