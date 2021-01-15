package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.PublicBusiness;
import com.boraydata.hygiene.web.request.PublicRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    PublicBusiness publicBusiness;

    @RequestMapping("/find/public")
    public MyResult findPublic(@RequestBody PublicRequest publicRequest) {
        return MyResult.success(publicBusiness.listPublicInfo(publicRequest));
    }

    @RequestMapping("/consultation")
    public MyResult consultation() {
        return MyResult.success();
    }

}
