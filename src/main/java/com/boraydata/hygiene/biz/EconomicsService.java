package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.web.request.EconomicsRequest;

import java.util.List;

public interface EconomicsService {

    List<EconomicsEntity> listMainEconomics(EconomicsRequest economicsRequest);

}
