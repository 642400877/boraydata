package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.SchoolEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchoolMapper {

    @Select("select id, student_number studentNumber, teacher_number teacherNumber, security_number securityNumber, choumidu, data_time dataTime " +
            "from hygiene.school")
    List<SchoolEntity> listSchoolInfo();

}
