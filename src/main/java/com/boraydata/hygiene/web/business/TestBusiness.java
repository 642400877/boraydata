package com.boraydata.hygiene.web.business;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.boraydata.hygiene.biz.TestService;
import com.boraydata.hygiene.dal.entity.TestEntity;
import com.boraydata.hygiene.web.response.TestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TestBusiness {

    @Autowired
    TestService testService;

    public List<TestEntity> test() {
        List<TestEntity> testEntityList = testService.listTestInfo();
        log.info(JSON.toJSONString(testEntityList));
        return testEntityList;
    }

}
