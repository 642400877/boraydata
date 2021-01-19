package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.common.searchResult.SearchResult;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.dal.entity.PublicEntity;
import com.boraydata.hygiene.web.business.PublicBusiness;
import com.boraydata.hygiene.web.request.PublicRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
