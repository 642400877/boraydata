package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.SchoolService;
import com.boraydata.hygiene.common.searchResult.SearchResult;
import com.boraydata.hygiene.common.util.CollectionUtil;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.dal.mapper.SchoolMapper;
import com.boraydata.hygiene.web.request.SchoolRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolMapper schoolMapper;

    public List<SchoolEntity> listSchoolInfo(SchoolRequest schoolRequest) {
        List<SchoolEntity> schoolEntityList = new ArrayList<>();

        if (SearchResult.myPopulationEntityList == null){
            schoolEntityList = schoolMapper.listSchoolInfo();
            SearchResult.mySchoolEntityList = schoolEntityList;
        }else {
            schoolEntityList = SearchResult.mySchoolEntityList;
        }

        return CollectionUtil.sublistLoop(schoolEntityList, schoolRequest.getIndex(), schoolRequest.getSize());
    }

}
