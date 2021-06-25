package com.boraydata.hygiene.web.request;

import lombok.Data;

import java.util.List;

@Data
public class AreaRequest {

    private String province;

    private List<String> provinceList;

    private String placeName;

}
