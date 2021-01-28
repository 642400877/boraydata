package com.boraydata.hygiene.biz.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PlaceInfoDto {

    private Long id;

    private String placeName;

    private Date dateTime;

    private PlaceDataDto data;

}
