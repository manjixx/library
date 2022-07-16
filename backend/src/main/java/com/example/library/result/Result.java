package com.example.library.result;

/**
 * Author：
 * Date：2022/7/914:49
 * Desc:
 */
public class Result {
    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //响应码
    private int code;
}
