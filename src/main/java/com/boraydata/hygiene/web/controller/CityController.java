package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.SchoolBusiness;
import com.boraydata.hygiene.web.request.SchoolRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private/v1")
public class CityController {

    @Autowired
    SchoolBusiness schoolBusiness;

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
        return MyResult.success(schoolBusiness.schoolInfo(schoolRequest));
    }
}
