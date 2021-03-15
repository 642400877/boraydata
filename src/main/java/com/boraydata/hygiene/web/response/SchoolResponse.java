package com.boraydata.hygiene.web.response;

import lombok.Data;

import java.util.List;

@Data
public class SchoolResponse {

    private String schoolName;

    private String schoolPosition;

    private List<String> schoolBuildList;

}
