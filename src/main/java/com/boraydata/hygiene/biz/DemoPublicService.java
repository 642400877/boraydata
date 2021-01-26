package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.web.request.DemoListRequest;

import java.util.List;

public interface DemoPublicService {

    public List<PopulationEntity> findPopulationInfoByPlaceName(DemoListRequest demoListRequest);

    List<PopulationEntity> addPopulationInfo(DemoListRequest demoListRequest, Integer size) throws NoSuchFieldException, IllegalAccessException, InstantiationException ;
}
