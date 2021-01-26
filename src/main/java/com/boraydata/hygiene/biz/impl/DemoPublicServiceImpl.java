package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.DemoPublicService;
import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import com.boraydata.hygiene.common.type.DemoRandomType;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.dal.mapper.DemoPublicMapper;
import com.boraydata.hygiene.dal.query.DemoPopulationQuery;
import com.boraydata.hygiene.web.request.DemoListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class DemoPublicServiceImpl implements DemoPublicService {

    @Autowired
    DemoPublicMapper demoPublicMapper;

    private static final String POPULATION = "population";

    @Override
    public List<PopulationEntity> findPopulationInfoByPlaceName(DemoListRequest demoListRequest) {
        DemoPopulationQuery demoPopulationQuery = new DemoPopulationQuery();
        demoPopulationQuery.setPlaceName(demoListRequest.getPlaceName());
        demoPopulationQuery.setSize(demoListRequest.getSize());
        List<PopulationEntity> populationEntityList = demoPublicMapper.findPopulationInfoByPlaceName(demoPopulationQuery);
        Collections.reverse(populationEntityList);
        return populationEntityList;
    }

    public List<PopulationEntity> addPopulationInfo(DemoListRequest demoListRequest, Integer size) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Random rand = new Random();
        List<PopulationEntity> populationEntityList = new ArrayList<>();
        Field[] fields = PopulationEntity.class.getDeclaredFields();
        for(int j = 0; j < size; j++) {
            PopulationEntity populationEntity = new PopulationEntity();
            for (int i = 0; i < fields.length; i++) {
                Field field = populationEntity.getClass().getDeclaredField(fields[i].getName());
                RandomAnnotation randomAnnotation = field.getAnnotation(RandomAnnotation.class);
                if (randomAnnotation != null) {
                    double num  = rand.nextInt(randomAnnotation.max()) + randomAnnotation.min();
                    if (randomAnnotation.needFloat()) {
                        num  = num / Math.pow(10, randomAnnotation.floatNumber());
                    }
                    field.setAccessible(true);
                    field.set(populationEntity, num);
                }
            }
            populationEntity.setPlaceName(demoListRequest.getPlaceName());
            populationEntityList.add(populationEntity);
        }
        demoPublicMapper.addPopulationInfoBatch(populationEntityList);
        return populationEntityList;
    }


}
