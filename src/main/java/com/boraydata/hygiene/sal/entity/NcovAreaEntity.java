package com.boraydata.hygiene.sal.entity;

import lombok.Data;

import java.util.List;

@Data
public class NcovAreaEntity {

    private String area;

    private String date;

    private Integer diagnosisCount;

    private Integer cureCount;

    private Integer deadCount;

}
