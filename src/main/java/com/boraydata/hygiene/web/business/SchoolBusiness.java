package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.SchoolService;
import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.dal.entity.SchoolInfoEntity;
import com.boraydata.hygiene.web.request.SchoolRequest;
import com.boraydata.hygiene.web.response.SchoolResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SchoolBusiness {

    @Autowired
    SchoolService schoolService;

    public SchoolResponse school(SchoolRequest schoolRequest) {
        SchoolEntity schoolEntity = schoolService.school(schoolRequest);
        SchoolResponse schoolResponse = new SchoolResponse();
        schoolResponse.setSchoolBuildList(new ArrayList<>());
        schoolResponse.getSchoolBuildList().addAll(Arrays.asList(schoolEntity.getSchoolBuildListStr().split(",")));
        schoolResponse.setSchoolName(schoolEntity.getSchoolName());
        schoolResponse.setSchoolPosition(schoolEntity.getSchoolPosition());
        return schoolResponse;
    }

    public SchoolInfoEntity schoolInfo(SchoolRequest schoolRequest) {
        return schoolService.schoolInfo(schoolRequest);
    }

}
