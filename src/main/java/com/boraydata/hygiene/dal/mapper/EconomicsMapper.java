package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.EconomicsEntity;
import com.boraydata.hygiene.dal.query.EconomicsQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EconomicsMapper {

    @Select("select count(1) " +
            "from hygiene.economics " +
            "where place_name = #{economicsQuery.placeName}")
    Integer findPopulationInfoExistByPlaceName(@Param("economicsQuery") EconomicsQuery economicsQuery);

    @Select("select id, place_name placeName, gdp, cpi, social_fixed_assets socialFixedAssets, revenue, budget, speed_increase speedIncrease, loss, data_time dataTime " +
            "from hygiene.economics " +
            "where place_name = #{economicsQuery.placeName}" +
            "order by id desc limit #{economicsQuery.limit}")
    List<EconomicsEntity> findEconomicsInfoByPlaceName(@Param("economicsQuery") EconomicsQuery economicsQuery);

    @Select("<script>" +
            "select id, gdp, cpi, social_fixed_assets socialFixedAssets, revenue, budget, speed_increase speedIncrease, loss, data_time dataTime " +
            "from hygiene.economics where place_name in " +
            "<foreach item='item' collection='economicsQuery.placeNameList' open='(' close=')' separator=','>" +
            "#{item} " +
            "</foreach>" +
            "</script>")
    List<EconomicsEntity> findEconomicsInfoListByPlaceName(@Param("economicsQuery") EconomicsQuery economicsQuery);

    @Insert("<script>" +
            "insert into hygiene.economics(place_name, gdp, cpi, social_fixed_assets, revenue, budget, speed_increase, loss, data_time, create_time, update_time, delete_type) " +
            "values " +
            "<foreach item='item' collection='economicsEntityList' separator=','>" +
            "(#{item.placeName},#{item.gdp}, #{item.cpi}, #{item.socialFixedAssets},#{item.revenue},#{item.budget},#{item.speedIncrease},#{item.loss}, " +
            "#{item.dataTime},now(),now(),0) " +
            "</foreach>" +
            "</script>")
    boolean addEconomicsInfoList(@Param("economicsEntityList") List<EconomicsEntity> economicsEntityList);

}
