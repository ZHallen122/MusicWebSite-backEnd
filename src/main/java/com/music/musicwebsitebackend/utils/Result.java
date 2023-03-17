package com.music.musicwebsitebackend.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* common result
* */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {
    private int code;

    private String message;

    private String type;

    private boolean success;

    private Object data;

    public static <T>Result<T> success(String message) {
        Result r = new Result();
        r.message=message;
        r.success=true;
        r.code=1;
        r.data=null;
        return r;
    }

    public static <T>Result<T> success(T data, String message) {
        Result r = new Result();
        r.message=message;
        r.success=true;
        r.code=1;
        r.data=data;
        return r;
    }

    public static <T>Result<T> success(T data) {
        Result r = new Result();
        r.data=data;
        r.code=1;
        r.success=true;
        return r;
    }

    public static <T>Result<T> warning(String message) {
        Result r = error(message);
        r.code=0;
        r.message=message;
        return r;
    }

    public static <T>Result<T> error(String message) {
        Result r = new Result();
        r.code=0;
        r.success=false;
        r.message=message;
        return r;
    }

    public static Result fatal(String message) {
        Result r = new Result();
        r.code=500;
        return r;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}

