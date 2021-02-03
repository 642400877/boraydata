package com.boraydata.hygiene.dal.entity;

import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import lombok.Data;

import java.util.Date;

@Data
public class PopulationEntity {

    /**
     * 人口数量
     * 人口浮动在-10000~20000
     * */
    @RandomAnnotation(max = 9000000,maxFloat = 20000, minFloat = -10000)
    private Integer populationNumber;
    /**
     * 出生率
     * 出生率浮动在-3%~3%
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2, maxFloat = 300, minFloat = -300)
    private Float birthRate;

    /**
     * 出生人数
     * 出生人数浮动在-300~300
     */
    @RandomAnnotation(max = 1000, maxFloat = 300, minFloat = -300)
    private Integer birthNumber;

    /**
     * 死亡率
     * 死亡率率浮动在-3%~3%
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2, maxFloat = 300, minFloat = -300)
    private  Float mortality;

    /**
     * 死亡人数
     * 出生人数浮动在-200~200
     */
    @RandomAnnotation(max = 1000, maxFloat = 200, minFloat = -200)
    private  Integer mortalityNumber;

    /**
     * 人口迁移指数
     * 人口迁移指数浮动在-3%~3%
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2, maxFloat = 300, minFloat = -300)
    private  Float migrationIndex;

    /**
     * 人口稠密度
     * 人口稠密度浮动在-3%~3%
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2, maxFloat = 300, minFloat = -300)
    private  Float populationDensity;

    /**
     * 疫情扩散曲线
     * 疫情扩散曲线浮动在-5~5
     */
    @RandomAnnotation(max = 20, maxFloat = 5, minFloat = -5)
    private Integer spread;
    /**
     * 治愈率
     * 治愈率浮动在-3%~3%
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2, maxFloat = 300, minFloat = -300)
    private Float cureRate;
    /**
     * 传播率
     * 传播率浮动在-3%~3%
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2, maxFloat = 300, minFloat = -300)
    private Float spreadRate;
    /**
     * 因感染死亡率
     * 因感染死亡率浮动在-3%~3%
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2, maxFloat = 300, minFloat = -300)
    private Float infectedMortality;
    /**
     * 因感染死亡数量
     * 因感染死亡数量浮动在-300~300
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2, maxFloat = 300, minFloat = -300)
    private Integer infectedDeathNumber;
    /**
     * 总新增感染人数
     * 总新增感染人数浮动在-20~20
     */
    @RandomAnnotation(max = 100, maxFloat = 20, minFloat = -20)
    private Integer totalIncrease;
    /**
     * 本土新增
     * 本土新增浮动在-100~100
     */
    @RandomAnnotation(max = 1000, maxFloat = 100, minFloat = -100)
    private Integer localIncrease;
    /**
     * 无症状感染
     * 无症状感染浮动在-50~50
     */
    @RandomAnnotation(max = 1000, maxFloat = 50, minFloat = -50)
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
