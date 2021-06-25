package com.boraydata.hygiene.biz.dto;

import lombok.Data;

@Data
public class PlaceDataDto {

    /**
     * 当前区域总人数
     */
    private Integer populationNumber;
    /**
     * 出生人数
     */
    private Integer birthNumber;
    /**
     * 死亡数量
     */
    private Integer deathNumber;
    /**
     * 出生率
     */
    private Float birthRate;
    /**
     * 死亡率
     */
    private Float mortality;
    /**
     * 人口迁移指数
     */
    private Integer migrationIndex;
    /**
     * gdp
     */
    private Integer gdp;
    /**
     * cpi
     */
    private Integer cpi;
    /**
     * 资产增速
     */
    private Integer assetsIncrease;
    /**
     * 口罩数量
     */
    private Integer maskNumber;
    /**
     * 防护服数量
     */
    private Integer clothingNumber;
    /**
     * 手套数量
     */
    private Integer gloveNumber;
    /**
     * 隔离间数量
     */
    private Integer isolationRoomNumber;
    /**
     * 体温枪数量
     */
    private Integer thermometerNumber;
    /**
     * 消毒液数量
     */
    private Integer disinfectantNumber;
    /**
     * 酒精数量
     */
    private Integer alcoholNumber;
    /**
     * 本土新增
     */
    private Integer localIncrease;
    /**
     * 无症状感染
     */
    private Integer asymptomatic;
    /**
     * 总新增
     */
    private Integer totalIncrease;
    /**
     * 因感染死亡数量
     */
    private Integer infectedDeathNumber;
    /**
     * 因感染死亡率
     */
    private Float infectedMortality;
    /**
     * 治愈率
     */
    private Float cureRate;
    /**
     * 传播率
     */
    private Float spreadRate;
    /**
     * 现存确诊
     */
    private Integer diagnosisNumber;
    /**
     * 经济损失
     */
    private Integer loss;
    /**
     * 疫情扩散曲线
     */
    private Integer spread;
    /**
     * 人口稠密度
     */
    private Double populationDensity;
}
