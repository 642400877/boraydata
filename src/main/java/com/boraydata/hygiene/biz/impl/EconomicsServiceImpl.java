package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.EconomicsService;
import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.dal.mapper.EconomicsMapper;
import com.boraydata.hygiene.dal.query.EconomicsQuery;
import com.boraydata.hygiene.web.request.EconomicsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EconomicsServiceImpl implements EconomicsService {

    @Autowired
    EconomicsMapper economicsMapper;

    @Override
    public Integer findEconomicsInfoExist(EconomicsRequest economicsRequest) {
        EconomicsQuery economicsQuery = new EconomicsQuery();
        economicsQuery.setPlaceName(economicsRequest.getPlaceName());
        return economicsMapper.findPopulationInfoExistByPlaceName(economicsQuery);
    }

    @Override
    public List<EconomicsEntity> listMainEconomics(EconomicsRequest economicsRequest) {
        EconomicsQuery economicsQuery = new EconomicsQuery();
        economicsQuery.setPlaceName(economicsRequest.getPlaceName());
        economicsQuery.setLimit(economicsRequest.getSize());
        return economicsMapper.findEconomicsInfoByPlaceName(economicsQuery);
    }

    @Override
    public boolean addEconomicsInfo(List<EconomicsEntity> economicsEntityList) {
        return economicsMapper.addEconomicsInfoList(economicsEntityList);
    }

}
