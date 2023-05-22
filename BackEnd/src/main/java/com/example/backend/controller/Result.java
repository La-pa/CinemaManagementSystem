package com.example.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.ObjectOutput;

@ApiModel("返回数据")
@Data
public class Result<T> {
    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("信息")
    private String msg;

    @ApiModelProperty("返回数据")
    private T data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Result(Integer code, T data, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // TODO 响应状态码
    // TODO 丰富接口
    // TODO 调整数据库，价格这个属性应该放在场次表中
    // TODO 处理异常的返回值
    // TODO

}
