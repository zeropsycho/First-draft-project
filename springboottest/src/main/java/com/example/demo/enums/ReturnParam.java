package com.example.demo.enums;

public enum ReturnParam {

    SUCCESS(100, "成功"),
    FAILURE(101, "失败");

    ReturnParam() {
    }

    ReturnParam(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 根据name
     * @return
     */
}
