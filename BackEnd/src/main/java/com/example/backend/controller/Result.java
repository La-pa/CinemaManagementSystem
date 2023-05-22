package com.example.backend.controller;

import lombok.Data;

import java.io.ObjectOutput;

@Data
public class Result<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 返回数据
     */
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
