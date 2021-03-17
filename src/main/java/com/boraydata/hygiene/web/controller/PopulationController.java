package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.PopulationBusiness;
import com.boraydata.hygiene.web.request.PopulationRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private/v1")
public class PopulationController {

    @Autowired
    PopulationBusiness populationBusiness;

    @RequestMapping(value = "population", method = RequestMethod.POST)
    public MyResult findPopulationList(@RequestBody PopulationRequest populationRequest) throws NoSuchFieldException, IllegalAccessException {
        return MyResult.success(populationBusiness.listPopulationInfo(populationRequest));
    }
}
