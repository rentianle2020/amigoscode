package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 用来throw exception
 */
public class ApiRequestException extends RuntimeException{

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
