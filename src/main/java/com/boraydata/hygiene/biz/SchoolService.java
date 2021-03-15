package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.dal.entity.SchoolInfoEntity;
import com.boraydata.hygiene.web.request.SchoolRequest;

public interface SchoolService {

    SchoolEntity school(SchoolRequest schoolRequest);

    SchoolInfoEntity schoolInfo(SchoolRequest schoolRequest);

}
