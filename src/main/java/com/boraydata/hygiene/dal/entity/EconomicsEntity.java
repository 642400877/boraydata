package com.boraydata.hygiene.dal.entity;

import lombok.Data;

@Data
public class EconomicsEntity {

    private Long id;
    /**
     * gdp
     */
    private String gdp;
    /**
     * cpi
     */
    private String cpi;
    /**
     * 社会固定资产
     */
    private String socialFixedAssets;
    /**
     * 财政收入
     */
    private String revenue;
    /**
     * 财政预算
     */
    private String budget;
    /**
     * 增速
     */
    private String speedIncrease;
    /**
     * 经济损失
     */
    private String loss;

    private String dataTime;

}
