package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.EconomicsBusiness;
import com.boraydata.hygiene.web.request.EconomicsRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EconomicsController {

    @Autowired
    EconomicsBusiness economicsBusiness;

    @RequestMapping("economics")
    public MyResult economics(@RequestBody EconomicsRequest economicsRequest) {
        return MyResult.success(economicsBusiness.listPopulationInfo(economicsRequest));
    }

}
