package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.web.request.SchoolRequest;

import java.util.List;

public interface SchoolService {

    List<SchoolEntity> listSchoolInfo(SchoolRequest schoolRequest);

}
