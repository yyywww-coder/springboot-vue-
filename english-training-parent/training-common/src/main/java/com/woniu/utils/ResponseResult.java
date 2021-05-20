package com.woniu.utils;

public class ResponseResult<T> {
    private int code; // 状态码 200,成功，500:失败，403：无权
    private String msg; // 消息
    private T data; // 数据

    public ResponseResult() {
    }

    public ResponseResult(T data) {
        this(200, "OK");
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public static final ResponseResult<Void> SUCCESS = new ResponseResult<>(200, "OK");
    public static final ResponseResult<Void> NOTLOGINED = new ResponseResult<>(401, "未登录");
    public static final ResponseResult<Void> FORBIDDEN = new ResponseResult<>(403, "无权限");
    public static final ResponseResult<Void> FAIL = new ResponseResult<>(500, "操作失败");
    public static final ResponseResult<Void> Unauthenticated = new ResponseResult<>(405, "错误的token");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
