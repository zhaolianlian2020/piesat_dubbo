package com.htht.common.exception;

/**
 * @program: debbo_piesat_sg
 * @description: 基础类
 * @author: Zhao Lianlian
 * @create: 2021-04-29 14:49
 */
public class BaseException extends RuntimeException {

    private int status = 1088;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BaseException() {
    }

    public BaseException(String message, int status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message) {
        super(message);
        this.status = 1088;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
