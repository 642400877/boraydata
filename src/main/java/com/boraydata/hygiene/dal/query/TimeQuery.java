package com.boraydata.hygiene.dal.query;

import lombok.Data;

import java.util.Date;

@Data
public class TimeQuery {

    /**
     * 起始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

}
