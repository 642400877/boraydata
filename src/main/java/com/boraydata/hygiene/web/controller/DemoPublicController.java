package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.DemoPublicBusiness;
import com.boraydata.hygiene.web.request.DemoListRequest;
import com.boraydata.hygiene.web.request.DemoPopulationNumberRequest;
import com.boraydata.hygiene.web.result.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/demo")
public class DemoPublicController {

    @Autowired
    DemoPublicBusiness demoPublicBusiness;

    @RequestMapping("population/list")
    public MyResult populationList(@RequestBody DemoListRequest demoListRequest) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        return MyResult.success(demoPublicBusiness.populationList(demoListRequest));
    }

    public MyResult populationNumberList(@RequestBody DemoPopulationNumberRequest demoPopulationNumberRequest) {
        return MyResult.success();
    }


}
