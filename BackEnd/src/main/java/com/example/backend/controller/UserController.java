package com.example.backend.controller;

import com.example.backend.entity.User;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


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
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping
    public Result<User> findAll() {
        List<User> users = userService.list();
        if (users == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        }
        return Result.success(users);
    }

    @ApiOperation("登入业务")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在"),
            @ApiResponse(code = 60012, message = "用户密码错误")})
    @PostMapping ("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user1 = userService.getById(user.getId());
        if (user1 == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        } else {
            System.out.println(user1);
            if (user1.getPassword().equals(user.getPassword())) {
                session.setAttribute("userId",user.getId());
                return Result.success();
            } else {
                throw  new BusinessException(Code.BUSINESS_ERROR_USER_PASSWORD_ERROR, "用户密码错误");
            }
        }
    }


    @ApiOperation("注册业务")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 20022, message = "数据保存失败"),
            @ApiResponse(code = 60013, message = "用户账号已存在")})
    @PostMapping("/register")
    public Result register(@RequestBody User user, HttpServletRequest request) {
        User user1 = userService.getById(user.getId());
        HttpSession session = request.getSession();
        if (user1 != null) {
            throw  new BusinessException(Code.BUSINESS_ERROR_USER_ACCOUNT_EXISTS, "用户账号已存在");
        } else {
            if (userService.save(user)) {
                session.setAttribute("userId",user.getId());
                return Result.success();
            } else {
                throw  new BusinessException(Code.INSERT_ERROR, "数据保存失败");
            }
        }
    }

    @ApiOperation(value = "修改用户密码")
    @PutMapping("/changePassword")
    public Result changePassword(@ApiParam("修改后密码的字符串") @RequestBody String s, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return new Result(Code.QUERY_ERROR, "请重新登入");
        }
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.getById(userId);
        if (user.getPassword().equals(s)) {
            return new Result(Code.BUSINESS_ERROR, "修改后的密码不能和原来密码相同");
        } else {
            user.setPassword(s);
            if (userService.updateById(user)) {
                return new Result(Code.SUCCESS, "密码修改成功");
            } else {
                return new Result(Code.BUSINESS_ERROR, "密码修改失败，请稍后再试");
            }
        }
    }


}
