package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.dal.entity.TestEntity;
import com.boraydata.hygiene.web.business.TestBusiness;
import com.boraydata.hygiene.web.response.TestResponse;
import com.boraydata.hygiene.web.result.Result;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    TestBusiness testBusiness;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Result test() {
        List<TestEntity> testEntityList = testBusiness.test();
        return Result.success(testEntityList);
    }

}
