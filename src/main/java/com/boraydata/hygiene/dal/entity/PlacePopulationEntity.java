package com.boraydata.hygiene.dal.entity;

import lombok.Data;

import java.util.List;

@Data
public class PlacePopulationEntity {

    private String placeName;

    private List<PopulationEntity> populationEntityList;

}
