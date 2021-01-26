package com.boraydata.hygiene.dal.entity;

import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import lombok.Data;
@Data
public class PopulationEntity {

    /**
     * 出生率
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private Double birthRate;

    /**
     * 出生人数
     */
    @RandomAnnotation(max = 1000)
    private Double birthNumber;

    /**
     * 死亡率
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private  Double mortality;

    /**
     * 死亡人数
     */
    @RandomAnnotation(max = 1000)
    private  Double mortalityNumber;

    /**
     * 人口迁移指数
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private  Double migrationIndex;

    /**
     * 人口稠密度
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private  Double populationDensity;

    /**
     * 数据日期
     */
    private  Integer dataTime;

    /**
     * 地点
     */
    private String placeName;
}
