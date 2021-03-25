package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.UserEntity;
import com.boraydata.hygiene.dal.query.UserQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select id, r_id rId, username, password, mobile, email, status " +
            "from hygiene.user_info " +
            "where username = #{userQuery.username}")
    UserEntity findUserInfoByUsername(@Param("userQuery") UserQuery userQuery);

    @Insert("insert into hygiene.user_info(r_id, username, password, mobile, email, status ) " +
            "values(#{userQuery.rId}, #{userQuery.username}, #{userQuery.password}, #{userQuery.mobile}, #{userQuery.email}, #{userQuery.status})")
    boolean addUserInfo(@Param("userQuery") UserQuery userQuery);

}
