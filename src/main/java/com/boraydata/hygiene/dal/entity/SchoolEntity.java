package com.boraydata.hygiene.dal.entity;

import lombok.Data;

@Data
public class SchoolEntity {

    private Long id;
    /**
     * 学生人数
     */
    private Long studentNumber;
    /**
     * 教职工人数
     */
    private  Long teacherNumber;
    /**
     * 安保人员数
     */
    private Long securityNumber;
    /**
     * 稠密度
     */
    private Float choumidu;
    /**
     * 数据时间
     */
    private Integer dataTime;
}
