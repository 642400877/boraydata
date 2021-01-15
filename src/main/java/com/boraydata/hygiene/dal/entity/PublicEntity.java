package com.boraydata.hygiene.dal.entity;

import lombok.Data;

@Data
public class PublicEntity {

    private Long id;
    /**
     * 人口稠密度
     */
    private Float consistency;
    /**
     * 人口数量
     */
    private Long populationNumber;
    /**
     * 物资储量
     */
    private Long reserves;
    /**
     * 防疫物资分布
     */
    private Long distribution;
    /**
     * 数据时间
     */
    private Integer dataTime;
}
