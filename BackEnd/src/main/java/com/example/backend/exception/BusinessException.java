package com.example.backend.exception;

import lombok.Data;

/**
 * 业务异常
 */
@Data
public class BusinessException extends RuntimeException {
    private Integer code;


    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }


}
