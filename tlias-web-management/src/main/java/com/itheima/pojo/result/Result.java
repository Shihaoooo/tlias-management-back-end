package com.itheima.pojo.result;


import lombok.Data;

@Data
public class Result {

    private Integer code; // 状态码
    private String msg; // 信息
    private Object data;  // 数据

    // 不带数据
    public static Result success(){
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    // 带数据
    public static Result success(Object object){
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";

        return result;

    }

    public static Result error(String msg){
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
