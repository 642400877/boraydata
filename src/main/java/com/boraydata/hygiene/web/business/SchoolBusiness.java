package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.SchoolService;
import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import com.boraydata.hygiene.common.excention.BusinessException;
import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.dal.entity.SchoolInfoEntity;
import com.boraydata.hygiene.dal.entity.SchoolSimulationEntity;
import com.boraydata.hygiene.web.request.SchoolRequest;
import com.boraydata.hygiene.web.response.SchoolResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class SchoolBusiness {

    @Autowired
    SchoolService schoolService;

    public SchoolResponse school(SchoolRequest schoolRequest) {
        SchoolEntity schoolEntity = schoolService.school(schoolRequest);
        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setSchoolBuildList(new ArrayList<>());
        schoolResponse.getSchoolBuildList().addAll(Arrays.asList(schoolEntity.getSchoolBuildListStr().split(",")));
        schoolResponse.setSchoolName(schoolEntity.getSchoolName());
        schoolResponse.setSchoolPosition(schoolEntity.getSchoolPosition());
        return schoolResponse;
    }

    public SchoolInfoEntity schoolInfo(SchoolRequest schoolRequest) {
        return schoolService.schoolInfo(schoolRequest);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<SchoolSimulationEntity> schoolSimulationInfo(SchoolRequest schoolRequest) {
        schoolService.findSchoolSimulationExist(schoolRequest);
        return schoolService.listSchoolSimulation(schoolRequest);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<SchoolSimulationEntity> listPopulationInfo(SchoolRequest schoolRequest) throws BusinessException {
        if(Objects.isNull(schoolRequest.getSize())) {
            schoolRequest.setSize(7);
        }
        List<SchoolSimulationEntity> schoolSimulationEntityList = new ArrayList<>();
        schoolRequest.getSchoolNameList().forEach(item -> {
            SchoolRequest schoolRequest2 = new SchoolRequest();
            schoolRequest2.setSchoolName(item);
            schoolRequest2.setSize(schoolRequest.getSize());
            Integer count = schoolService.findSchoolSimulationExist(schoolRequest2);
            int insertNumber = 1;
            if (count < schoolRequest.getSize()) {
                insertNumber = schoolRequest.getSize() - count;
            }
            try {
                this.addDemoSchoolSimulation(insertNumber, item);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new BusinessException("数据插入失败");
            }
            schoolSimulationEntityList.addAll(schoolService.listSchoolSimulation(schoolRequest2));
        });
        return schoolSimulationEntityList;
    }

    public void addDemoSchoolSimulation(Integer size, String schoolName) throws NoSuchFieldException, IllegalAccessException {
        Random rand = new Random();
        List<SchoolSimulationEntity> schoolSimulationEntityList = new ArrayList<>();
        Field[] fields = SchoolSimulationEntity.class.getDeclaredFields();
        for(int j = 0; j < size; j++) {
            SchoolSimulationEntity schoolSimulationEntity = new SchoolSimulationEntity();
            for (int i = 0; i < fields.length; i++) {
                Field field = schoolSimulationEntity.getClass().getDeclaredField(fields[i].getName());
                RandomAnnotation randomAnnotation = field.getAnnotation(RandomAnnotation.class);
                if (randomAnnotation != null) {
                    double num  = rand.nextInt(randomAnnotation.max()) + randomAnnotation.min();
                    if (randomAnnotation.needFloat()) {
                        num  = num / Math.pow(10, randomAnnotation.floatNumber());
                    }
                    field.setAccessible(true);
                    if("class java.lang.Integer".equals(field.getGenericType().toString())) {
                        field.set(schoolSimulationEntity, (int)num);
                    } else if("class java.lang.Float".equals(field.getGenericType().toString())) {
                        field.set(schoolSimulationEntity, (float)num);
                    } else if("class java.lang.Long".equals(field.getGenericType().toString())) {
                        field.set(schoolSimulationEntity, (long)num);
                    } else {
                        field.set(schoolSimulationEntity, num);
                    }
                }
            }
            schoolSimulationEntity.setSchoolName(schoolName);
            schoolSimulationEntityList.add(schoolSimulationEntity);
        }
        schoolService.addSchoolSimulation(schoolSimulationEntityList);
    }

    public List<SchoolResponse> listSchoolAll() {
        List<SchoolEntity> schoolEntityList = schoolService.listSchoolAll();
        List<SchoolResponse> schoolResponseList = new ArrayList<>();
        schoolEntityList.stream().forEach(item -> {
            SchoolResponse schoolResponse = new SchoolResponse();
            schoolResponse.setSchoolName(item.getSchoolName());
            schoolResponse.setSchoolPosition(item.getSchoolPosition());
            schoolResponseList.add(schoolResponse);
        });
        return schoolResponseList;
    }

}
