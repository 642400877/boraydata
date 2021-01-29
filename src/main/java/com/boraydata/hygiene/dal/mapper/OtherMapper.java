package com.boraydata.hygiene.dal.mapper;

import com.boraydata.hygiene.dal.entity.ReasonEntity;
import com.boraydata.hygiene.dal.query.ReasonQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OtherMapper {

    @Select("select id, full_name fullName, id_card_number idCardNumber, source, place_name placeName, reason, full_reason fullReason, portrait_url portraitUrl " +
            "from hygiene.reason ")
    ReasonEntity findReasonByPlaceName(@Param("reasonQuery") ReasonQuery reasonQuery);

    @Select("select video_url " +
            "from hygiene.video ")
    List<String> findVideo();

}
