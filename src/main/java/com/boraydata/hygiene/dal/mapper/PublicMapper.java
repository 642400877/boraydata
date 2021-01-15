package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.dal.entity.PublicEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PublicMapper {

    @Select("select id, consistency, population_number populationNumber, reserves, distribution, data_time dataTime " +
            "from hygiene.public")
    List<PublicEntity> listPublicInfo();

}
