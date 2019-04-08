package com.atguigu.demo.transaction.exception;

/**
 * @Author: lhh
 * @Date: 2019/4/8 21:48
 * @Version 1.0
 */
public class UserAccountException extends RuntimeException {
    public UserAccountException() {
    }

    public UserAccountException(String message) {
        super(message);
    }

    public UserAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountException(Throwable cause) {
        super(cause);
    }

    public UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
