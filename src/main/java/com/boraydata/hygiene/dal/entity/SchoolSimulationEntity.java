package com.boraydata.hygiene.dal.entity;

import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import lombok.Data;

@Data
public class SchoolSimulationEntity {

    private Long id;
    /**
     * 校园口稠密度
     */
    @RandomAnnotation(max = 30, min = 20, needFloat = true, floatNumber = 1)
    private Float schoolConsistency;
    /**
     * 人口数量
     */
    @RandomAnnotation(max = 10000, min = 7000)
    private Integer schoolPopulationNumber;
    /**
     * 安保人员数量
     */
    @RandomAnnotation(max = 50, min = 30)
    private Integer securityNumber;

    private String schoolName;
}
