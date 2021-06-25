package com.boraydata.hygiene.web.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MyResult implements Serializable {
    // 消息状态码
    private Integer code;
    // 消息
    private String msg;
    // 返回数据
    private Object data;

    private MyResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 响应成功(带返回数据)
     *
     * @param data 返回数据
     * @return Result
     */
    public static MyResult success(Object data) {
        return new MyResult(200, "响应成功", data);
    }

    /**
     * 响应成功
     *
     * @return Result
     */
    public static MyResult success() {
        return new MyResult(200, "响应成功", null);
    }

    /**
     * 响应错误(不带状态码,带消息)
     *
     * @return Result
     */
    public static MyResult error(String msg) {
        return new MyResult(500, msg, null);
    }

    /**
     * 响应错误(带错误码,消息提醒)
     *
     * @return
     */
    public static MyResult errorMsg(Integer code, String msg) {
        return new MyResult(code, msg, null);
    }


}
