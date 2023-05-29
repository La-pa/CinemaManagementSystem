package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.entity.Session;
import com.example.backend.exception.BusinessException;
import com.example.backend.service.SessionService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "场次信息")
@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;


    @ApiOperation("根据电影查询场次")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在")})
    @GetMapping("/{movieId}")
    public Result<Session> findById(@ApiParam(name = "movieId", value = "电影Id")@PathVariable Integer movieId) {
        LambdaQueryWrapper<Session> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Session::getMovieId, movieId);
        List<Session> sessions = sessionService.list(wrapper);
        if (sessions == null) {
            throw new BusinessException(Code.BUSINESS_ERROR_DATA_NOT_EXIST, "数据不存在");
        }
        return Result.success(sessions);
    }

    @ApiOperation("新增场次")
    @ApiResponses({@ApiResponse(code = 20000, message = "操作成功"),
            @ApiResponse(code = 60101, message = "数据不存在"),
            @ApiResponse(code = 20022, message = "数据插入失败")})
    @PostMapping
    public Result<Session> insertSession(@ApiParam(name = "session", value = "场次")@RequestBody Session session) {
        if (sessionService.save(session)) {
            throw new BusinessException(Code.INSERT_ERROR, "数据插入失败");
        }
        return Result.success();
    }

}
