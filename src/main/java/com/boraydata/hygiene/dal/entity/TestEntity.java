package com.boraydata.hygiene.dal.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class TestEntity {

    public Long id;

    public String userName;

    public Date createTime;

    public Date updateTime;
}
