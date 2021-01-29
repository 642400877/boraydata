package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.OtherService;
import com.boraydata.hygiene.dal.entity.ReasonEntity;
import com.boraydata.hygiene.web.request.OtherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherBusiness {

    @Autowired
    OtherService otherService;

    public ReasonEntity findReason(OtherRequest otherRequest) {
        return otherService.findReason(otherRequest);
    }

}
