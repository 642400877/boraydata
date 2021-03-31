package com.boraydata.hygiene.sal.entity;

import lombok.Data;

@Data
public class CityEntity {
    /**
     * 地区名
     */
    private String cityName;
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
    private Integer highDangerCount;
    /**
     *
     */
    private Integer midDangerCount;
    /**
     *
     */
    private Integer locationId;
    /**
     *
     */
    private Integer notShowCurrentConfirmedCount;
    /**
     *
     */
    private String currentConfirmedCountStr;
    /**
     *
     */
    private String cityEnglishName;

}
