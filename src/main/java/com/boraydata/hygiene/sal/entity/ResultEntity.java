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
     *
     */
    private Integer currentConfirmedCount;
    /**
     *
     */
    private Integer confirmedCount;
    /**
     *
     */
    private Integer suspectedCount;
    /**
     *
     */
    private Integer curedCount;
    /**
     *
     */
    private Integer deadCount;
    /**
     *
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
