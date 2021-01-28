package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.PlaceEntity;
import com.boraydata.hygiene.dal.query.PlaceQuery;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PlaceOtherMapper {

    @Select("select id, place_name placeName, place_id placeId " +
            "from hygiene.place_other_info " +
            "where place_name = #{placeQuery.placeName}")
    PlaceEntity findPlaceExist(@Param("placeQuery")PlaceQuery placeQuery);

    @Select("select id, place_name placeName, place_id placeId, data " +
            "from hygiene.place_other_info " +
            "where place_name = #{placeQuery.placeName}")
    PlaceEntity findPlaceInfo(@Param("placeQuery")PlaceQuery placeQuery);

    @Insert("insert info hygiene.place_other_info(place_name, place_id, data) " +
            "values(#{placeQuery.placeName}, #{placeQuery.placeId}, #{placeQuery.data})")
    boolean addPlaceInfo(@Param("placeQuery")PlaceQuery placeQuery);

    @Update("update hygiene.place_other_info " +
            "set data = #{placeQuery.data}")
    boolean updatePlaceInfo(@Param("placeQuery")PlaceQuery placeQuery);
}
