package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.MaterialService;
import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import com.boraydata.hygiene.common.excention.BusinessException;
import com.boraydata.hygiene.dal.entity.MaterialEntity;
import com.boraydata.hygiene.web.request.MaterialRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class MaterialBusiness {

    @Autowired
    MaterialService materialService;

    @Transactional(rollbackFor = Exception.class)
    public List<MaterialEntity> listMaterialInfo(MaterialRequest materialRequest) throws BusinessException {
        if (Objects.isNull(materialRequest.getSize())) {
            materialRequest.setSize(7);
        }
        if (Objects.isNull(materialRequest.getDemoFloat())) {
            materialRequest.setDemoFloat(3);
        }
        List<MaterialEntity> materialEntityList = new ArrayList<>();
        materialRequest.getPlaceNameList().forEach(item -> {
            MaterialRequest materialRequest2 = new MaterialRequest();
            materialRequest2.setPlaceName(item);
            materialRequest2.setSize(materialRequest.getSize());
            Integer count = materialService.findMaterialInfoExist(materialRequest2);
            int insertNumber = 1;
            if (count < materialRequest.getSize()) {
                insertNumber = materialRequest.getSize() - count;
            }
            try {
                this.addDemoMaterial(insertNumber, item);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            materialEntityList.addAll(materialService.listMainMaterial(materialRequest2));
        });
        return materialEntityList;
    }

    public void addDemoMaterial(Integer size, String placeName) throws NoSuchFieldException, IllegalAccessException {
        Random rand = new Random();
        List<MaterialEntity> materialEntityList = new ArrayList<>();
        Field[] fields = MaterialEntity.class.getDeclaredFields();
        for (int j = 0; j < size; j++) {
            MaterialEntity materialEntity = new MaterialEntity();
            for (int i = 0; i < fields.length; i++) {
                Field field = materialEntity.getClass().getDeclaredField(fields[i].getName());
                RandomAnnotation randomAnnotation = field.getAnnotation(RandomAnnotation.class);
                if (randomAnnotation != null) {
                    double num = rand.nextInt(randomAnnotation.max()) + randomAnnotation.min();
                    if (randomAnnotation.needFloat()) {
                        num = num / Math.pow(10, randomAnnotation.floatNumber());
                    }
                    field.setAccessible(true);
                    if ("class java.lang.Integer".equals(field.getGenericType().toString())) {
                        field.set(materialEntity, (int) num);
                    } else if ("class java.lang.Float".equals(field.getGenericType().toString())) {
                        field.set(materialEntity, (float) num);
                    } else if ("class java.lang.Long".equals(field.getGenericType().toString())) {
                        field.set(materialEntity, (long) num);
                    } else {
                        field.set(materialEntity, num);
                    }
                }
            }
            materialEntity.setPlaceName(placeName);
            materialEntityList.add(materialEntity);
        }
        materialService.addMaterialInfo(materialEntityList);
    }

}
