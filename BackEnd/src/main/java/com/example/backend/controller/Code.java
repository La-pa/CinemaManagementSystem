package com.example.backend.controller;

public class Code {

    public static final Integer SUCCESS = 200000;
    public static final Integer QUERY_ERROR = 20012;

    public static final Integer INSERT_SUCCESS = 20021;
    public static final Integer INSERT_ERROR = 20022;


    public static final Integer DELETE_SUCCESS = 20041;
    public static final Integer DELETE_ERROR = 20042;

    public static final Integer SYSTEM_ERROR = 50001;
    public static final Integer SYSTEM_UNKNOWN_ERROR = 59999;


    public static final Integer BUSINESS_ERROR = 60001;

    /**
     * 用户未登入
     */
    public static final Integer BUSINESS_ERROR_USER_NOT_LOGIN = 60011;

    /**
     * 用户密码错误
     */
    public static final Integer BUSINESS_ERROR_USER_PASSWORD_ERROR = 60012;

    /**
     * 用户账号存在
     */
    public static final Integer BUSINESS_ERROR_USER_ACCOUNT_EXISTS = 60013;

    /**
     * 数据不存在
     */
    public static final Integer BUSINESS_ERROR_DATA_NOT_EXIST = 60101;




}
