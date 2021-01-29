package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.EconomicsService;
import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import com.boraydata.hygiene.common.excention.BusinessException;
import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.web.request.EconomicsRequest;
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
public class EconomicsBusiness {

    @Autowired
    EconomicsService economicsService;

    @Transactional(rollbackFor = Exception.class)
    public List<EconomicsEntity> listPopulationInfo(EconomicsRequest economicsRequest) throws BusinessException {
        if(Objects.isNull(economicsRequest.getSize())) {
            economicsRequest.setSize(7);
        }
        if(Objects.isNull(economicsRequest.getDemoFloat())) {
            economicsRequest.setDemoFloat(3);
        }
        List<EconomicsEntity> economicsEntityList = new ArrayList<>();
        economicsRequest.getPlaceNameList().forEach(item -> {
            EconomicsRequest economicsRequest2 = new EconomicsRequest();
            economicsRequest2.setPlaceName(item);
            economicsRequest2.setSize(economicsRequest.getSize());
            Integer count = economicsService.findEconomicsInfoExist(economicsRequest2);
            int insertNumber = 1;
            if (count < economicsRequest.getSize()) {
                insertNumber = economicsRequest.getSize() - count;
            }
            try {
                this.addDemoEconomics(insertNumber, item);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            economicsEntityList.addAll(economicsService.listMainEconomics(economicsRequest2));
        });
        return economicsEntityList;
    }

    public void addDemoEconomics(Integer size, String placeName) throws NoSuchFieldException, IllegalAccessException {
        Random rand = new Random();
        List<EconomicsEntity> economicsEntityList = new ArrayList<>();
        Field[] fields = EconomicsEntity.class.getDeclaredFields();
        for(int j = 0; j < size; j++) {
            EconomicsEntity economicsEntity = new EconomicsEntity();
            for (int i = 0; i < fields.length; i++) {
                Field field = economicsEntity.getClass().getDeclaredField(fields[i].getName());
                RandomAnnotation randomAnnotation = field.getAnnotation(RandomAnnotation.class);
                if (randomAnnotation != null) {
                    double num  = rand.nextInt(randomAnnotation.max()) + randomAnnotation.min();
                    if (randomAnnotation.needFloat()) {
                        num  = num / Math.pow(10, randomAnnotation.floatNumber());
                    }
                    field.setAccessible(true);
                    if("class java.lang.Integer".equals(field.getGenericType().toString())) {
                        field.set(economicsEntity, (int)num);
                    } else if("class java.lang.Float".equals(field.getGenericType().toString())) {
                        field.set(economicsEntity, (float)num);
                    } else if("class java.lang.Long".equals(field.getGenericType().toString())) {
                        field.set(economicsEntity, (long)num);
                    } else {
                        field.set(economicsEntity, num);
                    }
                }
            }
            economicsEntity.setPlaceName(placeName);
            economicsEntityList.add(economicsEntity);
        }
        economicsService.addEconomicsInfo(economicsEntityList);
    }

}
