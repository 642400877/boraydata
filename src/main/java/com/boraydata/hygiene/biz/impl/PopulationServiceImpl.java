package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.PopulationService;
import com.boraydata.hygiene.common.util.CollectionUtil;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.dal.mapper.PopulationMapper;
import com.boraydata.hygiene.web.request.PopulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationServiceImpl implements PopulationService {

    @Autowired
    PopulationMapper populationMapper;

    public List<PopulationEntity> listMainPopulation(PopulationRequest populationRequest) {
        List<PopulationEntity> populationEntityList = populationMapper.listPopulationInfo();
        return CollectionUtil.sublistLoop(populationEntityList, populationRequest.getIndex(), populationRequest.getSize());
    }
}
