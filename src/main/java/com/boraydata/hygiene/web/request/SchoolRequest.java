package com.boraydata.hygiene.web.request;

import lombok.Data;

import java.util.List;

@Data
public class SchoolRequest {

    private String schoolPosition;

    private String schoolName;

    private List<String> schoolNameList;

    private Long dataTime;

    private Integer size;

    private List<String> schoolBuildList;

}
