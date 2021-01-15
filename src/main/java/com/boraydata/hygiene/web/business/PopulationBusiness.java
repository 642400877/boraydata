package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.PopulationService;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.web.request.PopulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationBusiness {

    @Autowired
    PopulationService populationService;

    public List<PopulationEntity> listPopulationInfo(PopulationRequest populationRequest) {
        return populationService.listMainPopulation(populationRequest);
    }
}
