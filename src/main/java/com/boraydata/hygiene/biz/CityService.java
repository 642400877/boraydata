package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.FireControlEntity;
import com.boraydata.hygiene.web.request.FireControlRequest;

import java.util.List;

public interface CityService {

    FireControlEntity fireControlInfo(FireControlRequest fireControlRequest);

    List<FireControlEntity> fireControlInfoAll();

}
