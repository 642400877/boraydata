package com.boraydata.hygiene.web.request;

import lombok.Data;

import java.util.List;

@Data
public class AreaMapRequest {

    private String streetName;

    private Integer population;

    private List<List<Double>> path;

}
