package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.web.request.EconomicsRequest;
import com.boraydata.hygiene.web.request.PopulationRequest;

import java.util.List;

public interface EconomicsService {

    Integer findEconomicsInfoExist(EconomicsRequest economicsRequest);

    List<EconomicsEntity> listMainEconomics(EconomicsRequest economicsRequest);

    boolean addEconomicsInfo(List<EconomicsEntity> economicsEntityList);


}
