package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.request.EconomicsRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EconomicsController {

    @RequestMapping("economics")
    public MyResult economics(EconomicsRequest economicsRequest) {
        return MyResult.success();
    }

}
