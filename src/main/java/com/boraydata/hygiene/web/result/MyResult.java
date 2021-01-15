package com.boraydata.hygiene.web.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MyResult implements Serializable {
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

    private MyResult(Boolean flag, Integer code, String msg, Object data) {
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
    public static MyResult success(Object data){
        return new MyResult(true, 200, "响应成功", data);
    }

    /**
     * 响应成功
     * @return Result
     */
    public static MyResult success(){
        return new MyResult(true, 200, "响应成功", null);
    }

    /**
     * 响应错误(不带状态码,带消息)
     * @return Result
     */
    public static MyResult error(String msg){
        return new MyResult(false, 240, msg, null);
    }

    /**
     * 响应错误(带错误码,消息提醒)
     * @return
     */
    public static MyResult errorMsg(Integer code, String msg){
        return new MyResult(false, code, msg, null);
    }
}
