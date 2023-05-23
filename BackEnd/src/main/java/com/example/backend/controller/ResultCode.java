package com.example.backend.controller;

public enum ResultCode {

    SUCCESS(200, "成功"),
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    USER_NOT_LOGGED_IN(2001, "用户未登录"),
    USER_LOGIN_ERROR(2002, "用户不存在或密码错误"),
    USER_NOT_EXIST(2003, "用户不存在"),
    USER_HAS_EXISTED(2004, "用户已存在"),
    INSERT_FAIL(3001, "添加失败"),
    DELETE_FAIL(3002, "删除失败"),
    UPDATE_FAIL(3003, "更新失败"),
    QUERY_FAIL(3004, "查询为空");

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
