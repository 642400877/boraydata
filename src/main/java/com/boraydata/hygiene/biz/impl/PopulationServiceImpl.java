package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.PopulationService;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.dal.mapper.PlacePopulationMapper;
import com.boraydata.hygiene.dal.mapper.PopulationMapper;
import com.boraydata.hygiene.dal.query.PopulationQuery;
import com.boraydata.hygiene.web.request.PopulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PopulationServiceImpl implements PopulationService {

    @Autowired
    PopulationMapper populationMapper;

    @Autowired
    PlacePopulationMapper placePopulationMapper;

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

//    public List<PopulationEntity> listPopulation(PopulationRequest populationRequest) {
//        List<PopulationEntity> populationEntityList = new ArrayList<>();
//        populationRequest.getPlaceNameList().stream().forEach(item -> {
//            PopulationQuery populationQuery = new PopulationQuery();
//            populationQuery.setPlaceName(item);
//            populationQuery.setLimit(populationRequest.getSize());
//            populationEntityList.addAll(populationMapper.findPopulationInfoByPlaceName(populationQuery));
//        });
//        return populationEntityList;
//    }

    public boolean addPopulationInfo(List<PopulationEntity> populationEntity) {
        return populationMapper.addPopulationInfoList(populationEntity);
    }

//    public PlaceEntity findPopulationInfoExist(OnePlaceRequest onePlaceRequest) {
//        PlaceQuery placeQuery = new PlaceQuery();
//        placeQuery.setPlaceName(onePlaceRequest.getPlacerName());
//        return placePopulationMapper.findPlaceExist(placeQuery);
//    }

//    public List<PopulationEntity> findPopulationInfoList(PlaceRequest placeRequest) {
//        PlaceQuery placeQuery = new PlaceQuery();
//        placeQuery.setPlaceNameList(placeRequest.getPlaceNameList());
//        List<PlaceEntity> placeEntity = placePopulationMapper.findPopulationInfoList(placeQuery);
//        List<PopulationEntity> populationEntityList = new ArrayList<>();
//        placeEntity.stream().forEach(item -> {
//
//        });
//    }
}
