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

    @Select("select count(1) " +
            "from hygiene.school_simulation " +
            "where school_name = #{schoolQuery.schoolName}")
    Integer findSchoolSimulationExistBySchoolName(@Param("schoolQuery") SchoolQuery schoolQuery);

    @Select("select id, school_consistency schoolConsistency, school_population_number schoolPopulationNumber, security_number securityNumber, school_name schoolName " +
            "from hygiene.school_simulation " +
            "where school_name = #{schoolQuery.schoolName} " +
            "order by id desc limit #{schoolQuery.limit}")
    List<SchoolSimulationEntity> findSchoolSimulationInfoBySchoolName(@Param("schoolQuery") SchoolQuery schoolQuery);

    @Insert("<script>" +
            "insert into hygiene.school_simulation(school_consistency, school_population_number, security_number, school_name) " +
            "values " +
            "<foreach item='item' collection='schoolSimulationEntityList' separator=','>" +
            "(#{item.schoolConsistency}, #{item.schoolPopulationNumber}, #{item.securityNumber}, #{item.schoolName}) " +
            "</foreach>" +
            "</script>")
    boolean addSchoolSimulationInfoList(@Param("schoolSimulationEntityList") List<SchoolSimulationEntity> schoolSimulationEntityList);

    @Select("select id, school_name schoolName, school_position schoolPosition, school_build_list schoolBuildListStr " +
            "from school")
    List<SchoolEntity> findSchool();
}
