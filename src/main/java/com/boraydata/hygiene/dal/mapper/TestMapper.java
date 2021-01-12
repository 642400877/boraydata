package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {

    @Select("select id, user_name userName, create_time createTime, update_time updateTime from hygiene.test")
    List<TestEntity> listTestInfo();
}
