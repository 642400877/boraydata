package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.PopulationService;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.dal.mapper.PopulationMapper;
import com.boraydata.hygiene.dal.query.PopulationQuery;
import com.boraydata.hygiene.web.request.PopulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationServiceImpl implements PopulationService {

    @Autowired
    PopulationMapper populationMapper;

    public Integer findPopulationInfoExist(PopulationRequest populationRequest) {
        PopulationQuery populationQuery = new PopulationQuery();
        populationQuery.setPlaceName(populationRequest.getPlaceName());
        return populationMapper.findPopulationInfoExistByPlaceName(populationQuery);
    }

    public List<PopulationEntity> listMainPopulation(PopulationRequest populationRequest) {
        PopulationQuery populationQuery = new PopulationQuery();
        populationQuery.setPlaceName(populationRequest.getPlaceName());
        populationQuery.setLimit(populationRequest.getSize());
        return populationMapper.findPopulationInfoByPlaceName(populationQuery);
    }

    public boolean addPopulationInfo(List<PopulationEntity> populationEntityList) {
        return populationMapper.addPopulationInfoList(populationEntityList);
    }

}
