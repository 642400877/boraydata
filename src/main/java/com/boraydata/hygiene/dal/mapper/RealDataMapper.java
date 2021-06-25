package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.sal.entity.CityEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RealDataMapper {

//    @Insert("insert into hygiene.real_data(city_name, current_confirmed_count, confirmed_count, suspected_count, cured_count, dead_count, current_confirmed_count_incr, " +
//            "confirmed_count_incr, suspected_count_incr, cured_count_incr, dead_count_incr, serious_count_incr, update_time, create_time) " +
//            "values" +
//            "(#{cityEntity.cityName}, #{cityEntity.currentConfirmedCount}, #{cityEntity.confirmedCount}, #{cityEntity.suspectedCount}, #{cityEntity.curedCount}, #{cityEntity.deadCount}, #{cityEntity.currentConfirmedCountIncr}, " +
//            "#{cityEntity.confirmedCountIncr}, #{cityEntity.suspectedCountIncr}, #{cityEntity.curedCountIncr}, #{cityEntity.deadCountIncr}, #{cityEntity.seriousCountIncr}, #{cityEntity.updateTime}, now()")
//    void addRealData(@Param("cityEntity")CityEntity cityEntity);

    @Insert("insert into hygiene.real_data(city_name, current_confirmed_count, confirmed_count, suspected_count, cured_count, dead_count, high_danger_count, mid_danger_count, update_time, create_time) " +
            "values" +
            "(#{cityEntity.cityName}, #{cityEntity.currentConfirmedCount}, #{cityEntity.confirmedCount}, #{cityEntity.suspectedCount}, #{cityEntity.curedCount}, " +
            "#{cityEntity.deadCount}, #{cityEntity.highDangerCount}, #{cityEntity.midDangerCount}, #{cityEntity.updateTime}, now())")
    void addRealData(@Param("cityEntity") CityEntity cityEntity);

}
