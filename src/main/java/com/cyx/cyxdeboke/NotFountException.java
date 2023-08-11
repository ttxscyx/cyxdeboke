package com.cyx.cyxdeboke;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//自定义异常
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFountException extends RuntimeException{
    public NotFountException() {
        super();
    }

    public NotFountException(String message) {
        super(message);
    }

    public NotFountException(String message, Throwable cause) {
        super(message, cause);
    }
}
