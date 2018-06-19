package com.test.exception;

/**
 * 自定一异常
 * RuntimeExcetpion可回滚
 * Exception不可回滚
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
