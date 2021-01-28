package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.PopulationService;
import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import com.boraydata.hygiene.common.excention.BusinessException;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.web.request.PopulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class PopulationBusiness {

    @Autowired
    PopulationService populationService;

    @Transactional(rollbackFor = Exception.class)
    public List<PopulationEntity> populationInfo(PopulationRequest populationRequest) {
        populationService.findPopulationInfoExist(populationRequest);
        return populationService.listMainPopulation(populationRequest);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<PopulationEntity> listPopulationInfo(PopulationRequest populationRequest) throws BusinessException{
        if(Objects.isNull(populationRequest.getSize())) {
            populationRequest.setSize(7);
        }
        if(Objects.isNull(populationRequest.getDemoFloat())) {
            populationRequest.setDemoFloat(3);
        }
        List<PopulationEntity> populationEntityList = new ArrayList<>();
        populationRequest.getPlaceNameList().forEach(item -> {
            PopulationRequest populationRequest2 = new PopulationRequest();
            populationRequest2.setPlaceName(item);
            populationRequest2.setSize(populationRequest.getSize());
            Integer count = populationService.findPopulationInfoExist(populationRequest2);
            int insertNumber = 1;
            if (count < populationRequest.getSize()) {
                insertNumber = populationRequest.getSize() - count;
            }
            try {
                this.addDemoPopulation(insertNumber, item);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new BusinessException("数据插入失败");
            }
            populationEntityList.addAll(populationService.listMainPopulation(populationRequest2));
        });
        return populationEntityList;
    }

    public void addDemoPopulation(Integer size, String placeName) throws NoSuchFieldException, IllegalAccessException {
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
                    if("class java.lang.Integer".equals(field.getGenericType().toString())) {
                        field.set(populationEntity, (int)num);
                    } else if("class java.lang.Float".equals(field.getGenericType().toString())) {
                        field.set(populationEntity, (float)num);
                    } else if("class java.lang.Long".equals(field.getGenericType().toString())) {
                        field.set(populationEntity, (long)num);
                    } else {
                        field.set(populationEntity, num);
                    }
                }
            }
            populationEntity.setPlaceName(placeName);
            populationEntityList.add(populationEntity);
        }
        populationService.addPopulationInfo(populationEntityList);
    }
}
