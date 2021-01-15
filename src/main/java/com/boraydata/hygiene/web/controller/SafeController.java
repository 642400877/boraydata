package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.SafeBusiness;
import com.boraydata.hygiene.web.request.SchoolRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/safe")
public class SafeController {

    @Autowired
    SafeBusiness safeBusiness;

    @RequestMapping("/search/school")
    public MyResult searchSchoolInfo(@RequestBody SchoolRequest schoolRequest) {
        return MyResult.success(safeBusiness.listSchoolInfo(schoolRequest));
    }
}
