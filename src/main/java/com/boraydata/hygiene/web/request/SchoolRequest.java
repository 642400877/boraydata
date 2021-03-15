package com.boraydata.hygiene.web.request;

import lombok.Data;

import java.util.List;

@Data
public class SchoolRequest {

    private String schoolPosition;

    private String SchoolName;

    private Long dataTime;

    private List<String> schoolBuildList;

}
