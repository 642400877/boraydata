package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.MaterialEntity;
import com.boraydata.hygiene.dal.query.MaterialQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MaterialMapper {

    @Select("select count(1) " +
            "from hygiene.material " +
            "where place_name = #{materialQuery.placeName}")
    Integer findMaterialInfoExistByPlaceName(@Param("materialQuery") MaterialQuery materialQuery);

    @Select("select id, place_name placeName, assets_increase assetsIncrease, mask_number maskNumber, clothing_number clothingNumber, glove_number gloveNumber, isolation_room_number isolationRoomNumber, " +
            "thermometer_number thermometerNumber, disinfectant_number disinfectantNumber, alcohol_number alcoholNumber, data_time dataTime " +
            "from hygiene.material " +
            "where place_name = #{materialQuery.placeName}" +
            "order by id desc limit #{materialQuery.limit}")
    List<MaterialEntity> findMaterialInfoByPlaceName(@Param("materialQuery") MaterialQuery materialQuery);

    @Select("<script>" +
            "select id, place_name placeName, assets_increase assetsIncrease, mask_number maskNumber, clothing_number clothingNumber, glove_number gloveNumber, isolation_room_number isolationRoomNumber, " +
            "thermometer_number thermometerNumber, disinfectant_number disinfectantNumber, alcohol_number alcoholNumber, data_time dataTime " +
            "from hygiene.material where place_name in " +
            "<foreach item='item' collection='materialQuery.placeNameList' open='(' close=')' separator=','>" +
            "#{item} " +
            "</foreach>" +
            "</script>")
    List<MaterialEntity> findMaterialInfoListByPlaceName(@Param("materialQuery") MaterialQuery materialQuery);

    @Insert("<script>" +
            "insert into hygiene.material(place_name, mask_number, clothing_number, glove_number, isolation_room_number, " +
            "thermometer_number, disinfectant_number, alcohol_number, data_time, create_time, update_time, delete_type) " +
            "values " +
            "<foreach item='item' collection='materialEntityList' separator=','>" +
            "(#{item.placeName}, #{item.maskNumber}, #{item.clothingNumber}, #{item.gloveNumber}, #{item.isolationRoomNumber}, " +
            "#{item.thermometerNumber}, #{item.disinfectantNumber}, #{item.alcoholNumber}, " +
            "#{item.dataTime},now(),now(),0) " +
            "</foreach>" +
            "</script>")
    boolean addMaterialInfoList(@Param("materialEntityList") List<MaterialEntity> materialEntityList);

}
