package com.boraydata.hygiene.dal.entity;

import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import lombok.Data;

import java.util.Date;

@Data
public class PopulationEntity {

    @RandomAnnotation(max = 9000000)
    private Integer populationNumber;
    /**
     * 出生率
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private Float birthRate;

    /**
     * 出生人数
     */
    @RandomAnnotation(max = 1000)
    private Integer birthNumber;

    /**
     * 死亡率
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private  Float mortality;

    /**
     * 死亡人数
     */
    @RandomAnnotation(max = 1000)
    private  Integer mortalityNumber;

    /**
     * 人口迁移指数
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private  Float migrationIndex;

    /**
     * 人口稠密度
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private  Float populationDensity;

    /**
     * 疫情扩散曲线
     */
    @RandomAnnotation(max = 20)
    private Integer spread;
    /**
     * 治愈率
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private Float cureRate;
    /**
     * 传播率
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private Float spreadRate;
    /**
     * 因感染死亡率
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private Float infectedMortality;
    /**
     * 因感染死亡数量
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private Integer infectedDeathNumber;
    /**
     * 总新增感染人数
     */
    @RandomAnnotation(max = 100)
    private Integer totalIncrease;
    /**
     * 本土新增
     */
    @RandomAnnotation(max = 1000)
    private Integer localIncrease;
    /**
     * 无症状感染
     */
    @RandomAnnotation(max = 1000)
    private Integer asymptomatic;
    /**
     * 数据日期
     */
    private Date dataTime;
    /**
     * 地点
     */
    private String placeName;
}
