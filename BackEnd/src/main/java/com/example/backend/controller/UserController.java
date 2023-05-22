package com.example.backend.controller;

import com.example.backend.entity.User;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Api(tags = "用户信息")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询全部用户的信息
     * @return
     */
    @ApiOperation("查询全部用户的信息")
    @GetMapping
    public Result<User> findAll() {
        return new Result(Code.SUCCESS, userService.list(), "查询成功");
    }

    @ApiOperation("登入业务")
    @PostMapping("/login")
    public Result<User> login(@RequestBody User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user1 = userService.getById(user.getId());
        if (user1 == null) {
            throw new BusinessException(Code.BUSINESS_ERROR, "账号不存在");
        } else {
            System.out.println(user1);
            if (user1.getPassword().equals(user.getPassword())) {
                session.setAttribute("userId",user.getId());
                return new Result(Code.SUCCESS, "登入成功");
            } else {
                return new Result(Code.QUERY_ERROR, "密码错误");
            }
        }
    }


    @ApiOperation("注册业务")
    @PostMapping("/register")
    public Result<User> register(@RequestBody User user, HttpServletRequest request) {
        User user1 = userService.getById(user.getId());
        HttpSession session = request.getSession();
        if (user1 != null) {
            return new Result(Code.INSERT_ERROR, "用户已存在");
        } else {
            boolean flag = userService.save(user);
            if (flag) {
                session.setAttribute("userId",user.getId());
                return new Result(Code.INSERT_SUCCESS, "注册成功");
            } else {
                return new Result(Code.INSERT_ERROR, "系统繁忙，请稍后再试");
            }
        }
    }


}
