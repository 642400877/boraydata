package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.biz.OtherService;
import com.boraydata.hygiene.web.business.OtherBusiness;
import com.boraydata.hygiene.web.request.OtherRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private/v1")
public class OtherController {

    @Autowired
    OtherBusiness otherBusiness;

    @Autowired
    OtherService otherService;

    @RequestMapping("reason")
    public MyResult reason(@RequestBody OtherRequest otherRequest) {
        return MyResult.success(otherBusiness.findReason(otherRequest));
    }

    @RequestMapping("video")
    public MyResult video(@RequestBody OtherRequest otherRequest) {
        return MyResult.success(otherService.findVideo());
    }
}
