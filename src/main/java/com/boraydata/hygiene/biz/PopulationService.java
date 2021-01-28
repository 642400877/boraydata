package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.web.request.PopulationRequest;

import java.util.List;

public interface PopulationService {

    Integer findPopulationInfoExist(PopulationRequest populationRequest);

    List<PopulationEntity> listMainPopulation(PopulationRequest populationRequest);

//    List<PopulationEntity> listPopulation(PopulationRequest populationRequest);

    boolean addPopulationInfo(List<PopulationEntity> populationEntity);
}
