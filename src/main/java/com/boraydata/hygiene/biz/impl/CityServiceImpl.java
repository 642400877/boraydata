package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.CityService;
import com.boraydata.hygiene.dal.entity.FireControlEntity;
import com.boraydata.hygiene.dal.mapper.CityMapper;
import com.boraydata.hygiene.web.request.FireControlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    @Override
    public FireControlEntity fireControlInfo(FireControlRequest fireControlRequest) {
        FireControlEntity fireControlEntity = new FireControlEntity();
        Random random = new Random();
        fireControlEntity.setRescueSpeed(random.nextInt(6) + 10);
        fireControlEntity.setResource(random.nextInt(21) + 70);
        fireControlEntity.setHumanResource(random.nextInt(31) + 10);
        fireControlEntity.setFireControlName(fireControlRequest.getFireControlName());
        return fireControlEntity;
    }

    public List<FireControlEntity> fireControlInfoAll() {
        return cityMapper.findFireControlAll();
    }


}
