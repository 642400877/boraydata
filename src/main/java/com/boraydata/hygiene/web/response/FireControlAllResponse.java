package com.boraydata.hygiene.web.response;

import lombok.Data;

@Data
public class FireControlAllResponse {

    private String fireControlName;

    private String fireControlPosition;

    private Integer responseTime;

    private String status;

}
