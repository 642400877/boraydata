package com.boraydata.hygiene.web.response;

import lombok.Data;

import java.util.List;

@Data
public class AreaMapResponse {

    private String placeName;

    private Integer populationNumber;

    private List<List<Double>> path;

}
