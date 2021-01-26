package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.PopulationEntity;
import com.boraydata.hygiene.dal.query.DemoPopulationQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoPublicMapper {

    @Select("<script>select id, birth_number birthNumber, birth_rate birthRate, mortality_number mortalityNumber, mortality, place_name placeName, data_time dataTime, migration_index migrationIndex, population_density populationDensity " +
            "from hygiene.population " +
            "<if test='demoPopulationQuery.placeName != null'>" +
            "where place_name = #{demoPopulationQuery.placeName} " +
            "</if>" +
            "order by id desc limit " +
            "<choose>" +
            "<when test='demoPopulationQuery.size != null'> " +
            " #{demoPopulationQuery.size} " +
            "</when>" +
            "<otherwise> " +
            " 10 " +
            "</otherwise>" +
            "</choose>" +
            "</script>")
    List<PopulationEntity> findPopulationInfoByPlaceName(@Param("demoPopulationQuery") DemoPopulationQuery demoPopulationQuery);

    @Insert("<script> insert into hygiene.population(birth_number, birth_rate, mortality_number, mortality, " +
            "migration_index, population_density, place_name, create_time, update_time, delete_type) values" +
            "<foreach item='item' collection='populationEntityList' separator=','> " +
            "(#{item.birthNumber}, #{item.birthRate}, #{item.mortalityNumber}, #{item.mortality}, " +
            "#{item.migrationIndex}, #{item.populationDensity}, #{item.placeName}, now(), now(), 0) " +
            "</foreach>" +
            "</script>")
    boolean addPopulationInfoBatch(@Param("populationEntityList") List<PopulationEntity> populationEntityList);
}
