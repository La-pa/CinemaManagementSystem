package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.example.backend.entity.User;
import com.example.backend.mapper.UserMapper;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result findAll() {
        return new Result(Code.QUERY_SUCCESS, userService.list(), "查询成功");
    }
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user1 = userService.getById(user.getId());
        if (user1 == null) {
            return new Result(Code.QUERY_ERROR, "账号不存在");
        } else {
            System.out.println(user1);
            if (user1.getPassword().compareTo(user.getPassword()) == 0) {
                session.setAttribute("userId",user.getId().toString());
                return new Result(Code.QUERY_SUCCESS, "登入成功");
            } else {
                return new Result(Code.QUERY_ERROR, "密码错误");
            }
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user, HttpServletRequest request) {
        User user1 = userService.getById(user.getId());
        HttpSession session = request.getSession();
        if (user1 != null) {
            return new Result(Code.INSERT_ERROR, "用户已存在");
        } else {
            boolean flag = userService.save(user);
            if (flag) {
                session.setAttribute("userId",user.getId().toString());
                return new Result(Code.INSERT_SUCCESS, "注册成功");
            } else {
                return new Result(Code.INSERT_ERROR, "系统繁忙，请稍后再试");
            }
        }
    }
}
