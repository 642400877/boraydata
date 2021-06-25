package com.boraydata.hygiene.sal.entity;

import lombok.Data;

import java.util.List;

@Data
public class ResultEntity {

    /**
     * 地区id
     */
    private Integer locationId;
    /**
     * 州洲
     */
    private String continentName;
    /**
     * 洲英文名称
     */
    private String continentEnglishName;
    /**
     * 国家名称
     */
    private String countryEnglishName;
    /**
     *
     */
    private String countryFullName;
    /**
     * 省或者直辖市名
     */
    private String provinceName;
    /**
     * 省或者直辖市名英文名
     */
    private String provinceEnglishName;
    /**
     * 省或者直辖市名简称
     */
    private String provinceShortName;
    /**
     * 现存确诊人数（较昨日增加数量）
     * 值为confirmedCount(Incr) - curedCount(Incr) - deadCount(Incr)
     */
    private Integer currentConfirmedCount;
    /**
     * 累计确诊人数（较昨日增加数量）
     */
    private Integer confirmedCount;
    /**
     * 疑似感染人数（较昨日增加数量）
     */
    private Integer suspectedCount;
    /**
     * 治愈人数（较昨日增加数量）
     */
    private Integer curedCount;
    /**
     * 死亡人数（较昨日增加数量）
     */
    private Integer deadCount;
    /**
     * 其他信息
     */
    private String comment;
    /**
     *
     */
    private List<CityEntity> cities;
    /**
     *
     */
    private Long updateTime;

}
