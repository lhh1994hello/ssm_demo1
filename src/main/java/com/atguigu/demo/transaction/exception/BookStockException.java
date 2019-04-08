package com.atguigu.demo.transaction.exception;

/**
 * @Author: lhh
 * @Date: 2019/4/8 21:47
 * @Version 1.0
 */
public class BookStockException extends  RuntimeException {
    public BookStockException() {
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    public BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
