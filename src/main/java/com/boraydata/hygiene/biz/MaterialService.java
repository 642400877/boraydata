package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.dal.entity.MaterialEntity;
import com.boraydata.hygiene.web.request.MaterialRequest;

import java.util.List;

public interface MaterialService {

    Integer findMaterialInfoExist(MaterialRequest materialRequest);

    List<MaterialEntity> listMainMaterial(MaterialRequest materialRequest);

    boolean addMaterialInfo(List<MaterialEntity> materialEntityList);

}
