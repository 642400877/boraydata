package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.PlaceEntity;
import com.boraydata.hygiene.dal.query.PlaceQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlacePopulationMapper {

    @Select("select id, place_name placeName, place_id placeId " +
            "from hygiene.place_population_info " +
            "where place_name = #{placeQuery.placeName}")
    PlaceEntity findPlaceExist(@Param("placeQuery")PlaceQuery placeQuery);

//    @Select("<script>select id, place_name placeName,  " +
//            "from hygiene.place_population_info " +
//            "where place_name in" +
//            "<foreach item='item' collection='placeQuery.placeNameList' open='(' close=')' separator=','>" +
//            "#{item} " +
//            "</foreach>" +
//            "</foreach>")
//    List<PlaceEntity> findPopulationInfoList(@Param("placeQuery")PlaceQuery placeQuery);

    @Insert("<script>" +
            "insert info hygiene.place_population_info(place_name, place_id, data, data_time) " +
            "values" +
            "<foreach item='item' collection='placeQueryList' separator=','> " +
            "(#{item.placeName}, #{item.placeId}, #{item.data}, #{item.dataTime}) " +
            "</foreach>" +
            "</script>")
    boolean addPlaceInfoList(@Param("placeQuery") List<PlaceQuery> placeQueryList);

    @Update("update hygiene.place_population_info " +
            "set data = #{placeQuery.data}")
    boolean updatePlaceInfo(@Param("placeQuery")PlaceQuery placeQuery);
}
