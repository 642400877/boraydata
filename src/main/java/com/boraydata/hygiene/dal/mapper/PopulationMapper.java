package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.PopulationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PopulationMapper {

    @Select("select id, birth_number birthNumber, birth_rate birthRate, mortality_number mortalityNumber, mortality, data_time dataTime, migration_index migrationIndex, population_density populationDensity " +
            "from hygiene.population")
    List<PopulationEntity> listPopulationInfo();

}
