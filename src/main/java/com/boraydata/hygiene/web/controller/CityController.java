package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.CityBusiness;
import com.boraydata.hygiene.web.business.SchoolBusiness;
import com.boraydata.hygiene.web.request.FireControlRequest;
import com.boraydata.hygiene.web.request.SchoolRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/private/v1")
public class CityController {

    @Autowired
    SchoolBusiness schoolBusiness;

    @Autowired
    CityBusiness cityBusiness;

    @RequestMapping("school")
    public MyResult schoolInfo(@RequestBody SchoolRequest schoolRequest) {
        return MyResult.success(schoolBusiness.school(schoolRequest));
    }

    @RequestMapping("schoolInfo")
    public MyResult school(@RequestBody SchoolRequest schoolRequest) {
        return MyResult.success(schoolBusiness.schoolInfo(schoolRequest));
    }

    @RequestMapping("schoolSimulation")
    public MyResult schoolSimulation(@RequestBody SchoolRequest schoolRequest) {
        return MyResult.success(schoolBusiness.listPopulationInfo(schoolRequest));
    }

    @RequestMapping(value = "schoolDistribution", method = RequestMethod.GET)
    public MyResult schoolDistribution() {
        return MyResult.success(schoolBusiness.listSchoolAll());
    }

    @RequestMapping("fireControlInfo")
    public MyResult fireControlInfo(@RequestBody FireControlRequest fireControlRequest) {
        return MyResult.success(cityBusiness.fireControlInfo(fireControlRequest));
    }

    @RequestMapping(value = "fireControlDistribution", method = RequestMethod.GET)
    public MyResult fireControlDistribution() {
        return MyResult.success(cityBusiness.fireControlInfoAll());
    }
}
