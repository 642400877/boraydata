package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.dal.query.PopulationQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PopulationMapper {

    @Select("select count(1) " +
            "from hygiene.population " +
            "where place_name = #{populationQuery.placeName}")
    Integer findPopulationInfoExistByPlaceName(@Param("populationQuery") PopulationQuery populationQuery);


    @Select("select id, place_name placeName,population_number populationNumber, birth_number birthNumber, birth_rate birthRate, mortality_number mortalityNumber, mortality, data_time dataTime, migration_index migrationIndex, population_density populationDensity, " +
            "spread, cure_rate cureRate, spread_rate spreadRate, infected_mortality infectedMortality, infected_death_number infectedDeathNumber, " +
            "total_increase totalIncrease, local_increase localIncrease, asymptomatic, data_time dataTime, create_time createTime, update_time updateTime, delete_type deleteType " +
            "from hygiene.population " +
            "where place_name = #{populationQuery.placeName}" +
            "order by id desc limit #{populationQuery.limit}")
    List<PopulationEntity> findPopulationInfoByPlaceName(@Param("populationQuery") PopulationQuery populationQuery);

    @Select("<script>" +
            "select id, place_name placeName, birth_number birthNumber, birth_rate birthRate, mortality_number mortalityNumber, mortality, data_time dataTime, migration_index migrationIndex, population_density populationDensity, " +
            "spread, cure_rate cureRate, spread_rate spreadRate, infected_mortality infectedMortality, infected_death_number infectedDeathNumber, " +
            "total_increase totalIncrease, local_increase localIncrease, asymptomatic, data_time dataTime, create_time createTime, update_time updateTime, delete_type deleteType " +
            "from hygiene.population where place_name in " +
            "<foreach item='item' collection='populationQuery.placeNameList' open='(' close=')' separator=','>" +
            "#{item} " +
            "</foreach>" +
            "</script>")
    List<PopulationEntity> findPopulationInfoListByPlaceName(@Param("populationQuery") PopulationQuery populationQuery);

    @Insert("<script>" +
            "insert into hygiene.population(population_number, place_name, birth_number, birth_rate, mortality_number, mortality, data_time, migration_index, population_density, " +
            "spread, cure_rate, spread_rate, infected_mortality, infected_death_number, " +
            "total_increase, local_increase, asymptomatic, create_time, update_time, delete_type) " +
            "values " +
            "<foreach item='item' collection='populationEntityList' separator=','>" +
            "(#{item.populationNumber}, #{item.placeName}, #{item.birthNumber},#{item.birthRate},#{item.mortalityNumber},#{item.mortality},#{item.dataTime}, " +
            "#{item.migrationIndex},#{item.populationDensity},#{item.spread},#{item.cureRate},#{item.spreadRate},#{item.infectedMortality},#{item.infectedDeathNumber}, " +
            "#{item.totalIncrease},#{item.localIncrease},#{item.asymptomatic},now(),now(),0) " +
            "</foreach>" +
            "</script>")
    boolean addPopulationInfoList(@Param("populationEntityList") List<PopulationEntity> populationEntityList);

}
