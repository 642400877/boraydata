package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.dal.entity.SchoolSimulationEntity;
import com.boraydata.hygiene.dal.query.SchoolQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchoolMapper {

    @Select("select id, school_name schoolName, school_position schoolPosition, school_build_list schoolBuildListStr " +
            "from school " +
            "where school_name = #{schoolQuery.schoolName}")
    SchoolEntity findSchoolBySchoolName(@Param("schoolQuery") SchoolQuery schoolQuery);

    @Select("select id, consistency, population_number populationNumber, security_number securityNumber, school_name schoolName, school_place schoolPlace " +
            "from hygiene.schoolSimulation " +
            "where school_name = #{schoolQuery.schoolName} " +
            "order by id limit #{schoolQuery.limit}")
    SchoolSimulationEntity findSchoolSimulationInfoBySchoolName(@Param("schoolQuery")SchoolQuery schoolQuery);

    @Insert("<script>" +
            "insert into hygiene.population(population_number, securityNumber, birth_number, schoolName, schoolPlace " +
            "values " +
            "<foreach item='item' collection='schoolSimulationEntityList' separator=','>" +
            "(#{item.populationNumber}, #{item.securityNumber}, #{item.schoolName},#{item.schoolPlace} " +
            "</foreach>" +
            "</script>")
    boolean addSchoolSimulationInfoList(@Param("schoolSimulationEntityList") List<SchoolSimulationEntity> schoolSimulationEntityList);
}
