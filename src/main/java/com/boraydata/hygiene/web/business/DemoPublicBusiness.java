package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.DemoPublicService;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.web.request.DemoListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoPublicBusiness {

    @Autowired
    DemoPublicService demoPublicService;

    @Transactional(rollbackFor = Exception.class)
    public List<PopulationEntity> populationList(DemoListRequest demoListRequest) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        List<PopulationEntity> populationEntityList = demoPublicService.findPopulationInfoByPlaceName(demoListRequest);
        if (demoListRequest.getSize() - populationEntityList.size() > 0) {
            populationEntityList.addAll(demoPublicService.addPopulationInfo(demoListRequest, demoListRequest.getSize() - populationEntityList.size()));
        }
        return populationEntityList;
    }

}
