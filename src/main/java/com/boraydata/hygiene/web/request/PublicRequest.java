package com.boraydata.hygiene.web.request;

import lombok.Data;

@Data
public class PublicRequest {

    /**
     * 请求的长度 不要超过数据库的总数据
     */
    private Integer size;
    /**
     * 当前数据滚动的起始位置
     */
    private Integer index;

}
