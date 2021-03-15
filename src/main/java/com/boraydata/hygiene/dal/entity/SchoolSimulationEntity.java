package com.boraydata.hygiene.dal.entity;

import lombok.Data;

@Data
public class SchoolSimulationEntity {

    private Long id;
    /**
     * 校园口稠密度
     */
    private Float consistency;
    /**
     * 人口数量
     */
    private Integer populationNumber;
    /**
     * 安保人员数量
     */
    private Integer securityNumber;

    private String schoolName;

    private String schoolPlace;
}
