package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.PublicService;
import com.boraydata.hygiene.common.searchResult.SearchResult;
import com.boraydata.hygiene.common.util.CollectionUtil;
import com.boraydata.hygiene.dal.entity.PublicEntity;
import com.boraydata.hygiene.dal.mapper.PublicMapper;
import com.boraydata.hygiene.web.request.PublicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicServiceImpl implements PublicService {

    @Autowired
    PublicMapper publicMapper;
    
    public List<PublicEntity> listPublicInfo(PublicRequest publicRequest) {
        List<PublicEntity> publicEntityList = new ArrayList<>();

        if (SearchResult.myPublicEntity == null){
            publicEntityList = publicMapper.listPublicInfo();
            SearchResult.myPublicEntity = publicEntityList;
        }else {
            publicEntityList = SearchResult.myPublicEntity;
        }

        return CollectionUtil.sublistLoop(publicEntityList, publicRequest.getIndex(), publicRequest.getSize());
    }

}
