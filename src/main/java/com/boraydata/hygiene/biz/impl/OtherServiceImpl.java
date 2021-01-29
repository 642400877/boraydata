package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.OtherService;
import com.boraydata.hygiene.dal.entity.ReasonEntity;
import com.boraydata.hygiene.dal.mapper.OtherMapper;
import com.boraydata.hygiene.dal.query.ReasonQuery;
import com.boraydata.hygiene.web.request.OtherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherServiceImpl implements OtherService {

    @Autowired
    OtherMapper otherMapper;

    public ReasonEntity findReason(OtherRequest otherRequest) {
        ReasonQuery reasonQuery = new ReasonQuery();
        reasonQuery.setPlaceName(otherRequest.getPlaceName());
        return otherMapper.findReasonByPlaceName(reasonQuery);
    }

    @Override
    public List<String> findVideo() {
        return otherMapper.findVideo();
    }


}
