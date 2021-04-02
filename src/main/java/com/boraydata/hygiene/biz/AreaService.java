package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.AreaPopulationDetailsEntity;
import com.boraydata.hygiene.dal.entity.AreaPopulationHealthyEntity;

public interface AreaService {

    AreaPopulationDetailsEntity areaPopulationDetails();

    AreaPopulationHealthyEntity areaHealthyInfo();

}
