package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.TestService;
import com.boraydata.hygiene.biz.dto.TestDto;
import com.boraydata.hygiene.dal.entity.TestEntity;
import com.boraydata.hygiene.dal.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public List<TestEntity> listTestInfo() {
        List<TestEntity> testEntityList = testMapper.listTestInfo();
        return testEntityList;
    }
}
