package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.web.request.PopulationRequest;

import java.util.List;

public interface PopulationService {

    List<PopulationEntity> listMainPopulation(PopulationRequest populationRequest);

}
