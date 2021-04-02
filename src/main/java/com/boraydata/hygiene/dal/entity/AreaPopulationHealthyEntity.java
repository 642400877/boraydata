package com.boraydata.hygiene.dal.entity;

import lombok.Data;

@Data
public class AreaPopulationHealthyEntity {

    /**
     * 海淀区人口平均年龄
     */
    private Integer age;
    /**
     * 平均血压
     */
    private String bloodPressure;
    /**
     * 平均血糖
     */
    private String bloodSugar;
    /**
     * 平均血脂
     */
    private String bloodFat;
    /**
     * 平均体重指数
     */
    private String weightIndex;
    /**
     * 平均心率
     */
    private String heartRate;
    /**
     * 平均C反应蛋白指数
     */
    private String CReactiveProtein;
    /**
     * 甲乙丙类传染病
     */
    private Integer ABCInfectiousDiseases;
    /**
     * 报告发病
     */
    private Integer ReportDisease;
    /**
     * 报告发病率
     */
    private Float ReportDiseaseRate;
    /**
     * 年发病率下降
     */
    private Float morbidityDecline;
    /**
     * 病毒性肝炎下降
     */
    private Float ViralHepatitisDecline;
    /**
     * 水痘下降
     */
    private Float crystalliDecline;
    /**
     * 猩红热下降
     */
    private Float ScarletFeverDecline;
    /**
     * 传染病整体控制水平
     */
    private String epidemicSituationLevel;
}
