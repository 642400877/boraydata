package com.boraydata.hygiene.web.request;

import lombok.Data;

import java.util.List;

@Data
public class EconomicsRequest {

    private String placeName;

    private Integer placeId;

    private Integer demoFloat;

    private Integer size;

    private List<String> placeNameList;

}
