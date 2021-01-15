package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.EconomicsService;
import com.boraydata.hygiene.common.util.CollectionUtil;
import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.dal.mapper.EconomicsMapper;
import com.boraydata.hygiene.web.request.EconomicsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EconomicsServiceImpl implements EconomicsService {

    @Autowired
    EconomicsMapper economicsMapper;

    public List<EconomicsEntity> listMainEconomics(EconomicsRequest economicsRequest) {
        List<EconomicsEntity> economicsEntityList = economicsMapper.listEconomicsInfo();
        return CollectionUtil.sublistLoop(economicsEntityList, economicsRequest.getIndex(), economicsRequest.getSize());
    }

}
