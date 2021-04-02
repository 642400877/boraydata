package com.boraydata.hygiene.dal.entity;

import lombok.Data;

import java.util.Map;

@Data
public class AreaPopulationDetailsEntity {

    private Integer permanentPopulationNumber;

    private Integer permanentMigrantPopulationNumber;

    private Integer area;

    private Map<String, Integer> yearSexInfo;

    private Map<String, Integer> streetPopulationInfo;
}
