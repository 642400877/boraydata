package com.boraydata.hygiene.dal.entity;

import lombok.Data;

@Data
public class ReasonEntity {

    private Long id;

    private String fullName;

    private String idCardNumber;

    private String source;

    private String placeName;

    private String reason;

    private String fullReason;

    private String portraitUrl;

}
