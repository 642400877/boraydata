package com.boraydata.hygiene.sal.entity;

import lombok.Data;

import java.util.List;

@Data
public class AreaEntity {

    private List<ResultEntity> results;

    private Boolean success;
}
