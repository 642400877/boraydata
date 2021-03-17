package com.boraydata.hygiene.dal.entity;

import lombok.Data;

@Data
public class FireControlEntity {

    private String fireControlName;

    private String fireControlPosition;

    private Integer rescueSpeed;

    private Integer resource;

    private Integer humanResource;

}
