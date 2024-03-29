package com.example.backend.exception;

import lombok.Data;

/**
 * 系统异常
 */
@Data
public class SystemException extends RuntimeException {
    private Integer code;


    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }


}
