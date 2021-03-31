package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.RealDataService;
import com.boraydata.hygiene.dal.mapper.RealDataMapper;
import com.boraydata.hygiene.sal.entity.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealDataServiceImpl implements RealDataService {

    @Autowired
    RealDataMapper realDataMapper;

    @Override
    public void addRealData(CityEntity cityEntity) {
        realDataMapper.addRealData(cityEntity);
    }

}
