package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.SchoolService;
import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.web.request.SchoolRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafeBusiness {

    @Autowired
    SchoolService schoolService;

    public List<SchoolEntity> listSchoolInfo(SchoolRequest schoolRequest) {
        return schoolService.listSchoolInfo(schoolRequest);
    }
}
