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
}
