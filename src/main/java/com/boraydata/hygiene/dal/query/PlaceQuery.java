package com.boraydata.hygiene.dal.query;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlaceQuery {

    private Long id;

    private String placeName;

    private Integer placeId;

    private String data;

    private Date dataTime;

    private List<String> placeNameList;
}
