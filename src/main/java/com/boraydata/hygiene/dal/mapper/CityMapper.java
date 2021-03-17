package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.FireControlEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("select id, fire_control_name fireControlName, fire_control_position fireControlPosition " +
            "from hygiene.fire_control")
    List<FireControlEntity> findFireControlAll();

}
