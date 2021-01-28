package com.boraydata.hygiene.dal.query;

import lombok.Data;

import java.util.List;

@Data
public class EconomicsQuery {

    private String placeName;

    private List<String> placeNameList;

    private Integer limit;
}
