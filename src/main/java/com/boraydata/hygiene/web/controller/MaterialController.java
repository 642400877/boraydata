package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.web.business.MaterialBusiness;
import com.boraydata.hygiene.web.request.MaterialRequest;
import com.boraydata.hygiene.web.result.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private/v1")
public class MaterialController {

    @Autowired
    MaterialBusiness materialBusiness;

    @RequestMapping(value = "material", method = RequestMethod.POST)
    public MyResult material(@RequestBody MaterialRequest materialRequest) {
        return MyResult.success(materialBusiness.listMaterialInfo(materialRequest));
    }

}
