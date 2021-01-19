package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.EconomicsService;
import com.boraydata.hygiene.common.searchResult.SearchResult;
import com.boraydata.hygiene.common.util.CollectionUtil;
import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.dal.mapper.EconomicsMapper;
import com.boraydata.hygiene.web.request.EconomicsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EconomicsServiceImpl implements EconomicsService {

    @Autowired
    EconomicsMapper economicsMapper;

    public List<EconomicsEntity> listMainEconomics(EconomicsRequest economicsRequest) {
        List<EconomicsEntity> economicsEntityList = new ArrayList<>();

        if (SearchResult.myEconomicsEntityList == null){
            economicsEntityList = economicsMapper.listEconomicsInfo();
            SearchResult.myEconomicsEntityList = economicsEntityList;
        }else {
            economicsEntityList = SearchResult.myEconomicsEntityList;
        }

        return CollectionUtil.sublistLoop(economicsEntityList, economicsRequest.getIndex(), economicsRequest.getSize());
    }

}
