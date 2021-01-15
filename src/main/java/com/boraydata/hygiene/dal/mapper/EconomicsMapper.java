package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EconomicsMapper {

    @Select("select id, gdp, cpi, social_fixed_assets socialFixedAssets, revenue, budget, speed_increase speedIncrease, data_time dataTime " +
            "from hygiene.economics")
    List<EconomicsEntity> listEconomicsInfo();

}
