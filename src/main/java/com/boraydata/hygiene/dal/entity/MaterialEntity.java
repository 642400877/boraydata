package com.boraydata.hygiene.dal.entity;

import com.boraydata.hygiene.common.annotation.RandomAnnotation;
import lombok.Data;

import java.util.Date;

@Data
public class MaterialEntity {

    private Long id;
    /**
     * 口罩数量
     */
    @RandomAnnotation(max = 9000000)
    private Integer maskNumber;
    /**
     * 防护服数量
     */
    @RandomAnnotation(max = 9000000)
    private Integer clothingNumber;
    /**
     * 手套数量
     */
    @RandomAnnotation(max = 9000000)
    private Integer gloveNumber;
    /**
     * 隔离间数量
     */
    @RandomAnnotation(max = 9000000)
    private Integer isolationRoomNumber;
    /**
     * 体温枪数量
     */
    @RandomAnnotation(max = 9000000)
    private Integer thermometerNumber;
    /**
     * 消毒液数量
     */
    @RandomAnnotation(max = 9000000)
    private Integer disinfectantNumber;
    /**
     * 酒精数量
     */
    @RandomAnnotation(max = 9000000)
    private Integer alcoholNumber;
    /**
     * 地区名称
     */
    private String placeName;
    /**
     * 数据日期
     */
    private Date dataTime;
}
