package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.dal.entity.SchoolInfoEntity;
import com.boraydata.hygiene.dal.entity.SchoolSimulationEntity;
import com.boraydata.hygiene.web.request.SchoolRequest;

import java.util.List;

public interface SchoolService {

    SchoolEntity school(SchoolRequest schoolRequest);

    SchoolInfoEntity schoolInfo(SchoolRequest schoolRequest);

    Integer findSchoolSimulationExist(SchoolRequest schoolRequest);

    List<SchoolSimulationEntity> listSchoolSimulation(SchoolRequest schoolRequest);

    boolean addSchoolSimulation(List<SchoolSimulationEntity> schoolSimulationEntity);

    List<SchoolEntity> listSchoolAll();
}
