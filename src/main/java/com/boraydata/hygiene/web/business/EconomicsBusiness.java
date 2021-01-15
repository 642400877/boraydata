package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.EconomicsService;
import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.web.request.EconomicsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EconomicsBusiness {

    @Autowired
    EconomicsService economicsService;

    public List<EconomicsEntity> listEconomicsInfo(EconomicsRequest economicsRequest) {
        return economicsService.listMainEconomics(economicsRequest);
    }

}
