package com.boraydata.hygiene.dal.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PopulationEntity {

    /**
     * 出生率
     */
    private String birthRate;

    /**
     * 出生人数
     */
    private Long birthNumber;

    /**
     * 死亡率
     */
    private  String mortality;

    /**
     * 死亡人数
     */
    private  Long mortalityNumber;

    /**
     * 人口迁移指数
     */
    private  String migrationIndex;

    /**
     * 人口稠密度
     */
    private  String populationDensity;

    /**
     * 数据日期
     */
    private  Integer dataTime;

}
