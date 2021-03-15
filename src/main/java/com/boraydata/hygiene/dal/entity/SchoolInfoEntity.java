package com.boraydata.hygiene.dal.entity;

import lombok.Data;

@Data
public class SchoolInfoEntity {

    private String schoolName;

    private String schoolPosition;

    /**
     * 学生人数
     */
    private Integer studentNumber;
    /**
     * 教师人数
     */
    private Integer teacherNumber;
    /**
     * 安保人数
     */
    private Integer securityNumber;
    /**
     * 数据时间
     */
    private Long dataTime;
}
