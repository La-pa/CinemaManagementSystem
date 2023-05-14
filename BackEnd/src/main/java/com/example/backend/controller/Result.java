package com.example.backend.controller;

import lombok.Data;

import java.io.ObjectOutput;

@Data
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
