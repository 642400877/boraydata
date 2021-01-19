package com.boraydata.hygiene.common.searchResult;

import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.dal.entity.PublicEntity;
import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.web.request.PopulationRequest;

import java.util.List;

public class SearchResult {
    public static List<PublicEntity> myPublicEntity;
    public static List<EconomicsEntity> myEconomicsEntityList;
    public static List<PopulationEntity> myPopulationEntityList;
    public static List<SchoolEntity> mySchoolEntityList;
}
