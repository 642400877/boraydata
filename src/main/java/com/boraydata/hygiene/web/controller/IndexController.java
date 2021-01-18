package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.EconomicsBusiness;
import com.boraydata.hygiene.web.business.PopulationBusiness;
import com.boraydata.hygiene.web.request.EconomicsRequest;
import com.boraydata.hygiene.web.request.PopulationRequest;
import com.boraydata.hygiene.web.result.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/main")
public class IndexController {

    @Autowired
    PopulationBusiness populationBusiness;

    @Autowired
    EconomicsBusiness economicsBusiness;

    @RequestMapping("/find/population")
    public MyResult findPopulation(@RequestBody PopulationRequest populationRequest) {
        log.info("123123");
        return MyResult.success(populationBusiness.listPopulationInfo(populationRequest));
    }

    @RequestMapping("/find/economics")
    public MyResult findEconomics(@RequestBody EconomicsRequest economicsRequest) {
        return MyResult.success(economicsBusiness.listEconomicsInfo(economicsRequest));
    }
}
