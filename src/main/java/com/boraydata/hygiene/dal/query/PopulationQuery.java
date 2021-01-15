package com.boraydata.hygiene.dal.query;

import lombok.Data;

@Data
public class PopulationQuery {

    /**
     * 请求的长度 不要超过数据库的总数据
     */
    private Integer size;
    /**
     * 当前数据滚动的起始位置
     */
    private Integer index;

}
