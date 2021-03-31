package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.sal.client.Isaaclin;
import com.boraydata.hygiene.web.request.AreaRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/private/v1")
public class RealDataController {

    @Autowired
    Isaaclin isaaclin;

    @RequestMapping("area")
    public MyResult areaDate(@RequestBody AreaRequest areaRequest) throws UnsupportedEncodingException, URISyntaxException {
        return MyResult.success(isaaclin.areaApi(areaRequest));
    }

}
