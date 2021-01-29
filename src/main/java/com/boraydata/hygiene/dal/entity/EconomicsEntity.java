package com.boraydata.hygiene.dal.entity;

import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import lombok.Data;

@Data
public class EconomicsEntity {

    private Long id;
    /**
     * gdp
     */
    @RandomAnnotation(min = 7000000, max = 9000000)
    private Integer gdp;
    /**
     * cpi
     */
    @RandomAnnotation(min=100, max = 120)
    private Integer cpi;
    /**
     * 社会固定资产
     */
    @RandomAnnotation(min = 700000, max = 900000)
    private Integer socialFixedAssets;
    /**
     * 财政收入
     */
    @RandomAnnotation(min = 700000, max = 900000)
    private Integer revenue;
    /**
     * 财政预算
     */
    @RandomAnnotation(min = 700000, max = 900000)
    private Integer budget;
    /**
     * 增速
     */
    @RandomAnnotation(max = 1000, needFloat = true, floatNumber = 2)
    private Float speedIncrease;
    /**
     * 经济损失
     */
    @RandomAnnotation(min = 7000000, max = 9000000)
    private Integer loss;

    private String dataTime;

    private String placeName;
}
