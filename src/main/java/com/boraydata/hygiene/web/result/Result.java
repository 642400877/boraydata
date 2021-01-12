package com.boraydata.hygiene.web.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Result implements Serializable {
    // 结果标记(true:执行成功 false:执行失败)
    private Boolean flag;
    // 消息状态码
    private Integer code;
    // 消息
    private String msg;
    // 时间戳
    private Long time;
    // 返回数据
    private Object data;

    private Result(Boolean flag, Integer code, String msg, Object data) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.time = new Date().getTime();
        this.data = data;
    }

    /**
     * 响应成功(带返回数据)
     * @param data 返回数据
     * @return Result
     */
    public static Result success(Object data){
        return new Result(true, 200, "响应成功", data);
    }

    /**
     * 响应成功
     * @return Result
     */
    public static Result success(){
        return new Result(true, 200, "响应成功", null);
    }

    /**
     * 响应错误(不带状态码,带消息)
     * @return Result
     */
    public static Result error(String msg){
        return new Result(false, 240, msg, null);
    }

    /**
     * 响应错误(带错误码,消息提醒)
     * @return
     */
    public static Result errorMsg(Integer code,String msg){
        return new Result(false, code, msg, null);
    }
}
