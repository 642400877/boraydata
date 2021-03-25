package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.MaterialService;
import com.boraydata.hygiene.dal.entity.MaterialEntity;
import com.boraydata.hygiene.dal.mapper.MaterialMapper;
import com.boraydata.hygiene.dal.query.MaterialQuery;
import com.boraydata.hygiene.web.request.MaterialRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {


    @Autowired
    MaterialMapper materialMapper;

    @Override
    public Integer findMaterialInfoExist(MaterialRequest materialRequest) {
        MaterialQuery materialQuery = new MaterialQuery();
        materialQuery.setPlaceName(materialRequest.getPlaceName());
        return materialMapper.findMaterialInfoExistByPlaceName(materialQuery);
    }

    @Override
    public List<MaterialEntity> listMainMaterial(MaterialRequest materialRequest) {
        MaterialQuery materialQuery = new MaterialQuery();
        materialQuery.setPlaceName(materialRequest.getPlaceName());
        materialQuery.setLimit(materialRequest.getSize());
        return materialMapper.findMaterialInfoByPlaceName(materialQuery);
    }

    @Override
    public boolean addMaterialInfo(List<MaterialEntity> materialEntityList) {
        return materialMapper.addMaterialInfoList(materialEntityList);
    }

}
