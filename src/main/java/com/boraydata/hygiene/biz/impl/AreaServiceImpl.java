package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.AreaService;
import com.boraydata.hygiene.common.type.BadWellLevelType;
import com.boraydata.hygiene.common.type.LowHighLevelType;
import com.boraydata.hygiene.dal.entity.AreaPopulationDetailsEntity;
import com.boraydata.hygiene.dal.entity.AreaPopulationHealthyEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AreaServiceImpl implements AreaService {

    /**
     * 常住人口
     */
    public static Integer permanentPopulationNumber;
    /**
     * 常驻外来人口
     */
    public static Integer permanentMigrantPopulationNumber;
    /**
     * 海淀区面积
     */
    public final static Integer AREA = 431;
    /**
     * 街道人口比重
     */
    public static Map<String, Integer> populationMap;
    /**
     * 年纪性别
     */
    public static Map<String, Integer> yearSexMap;

    private void initPopulationMap() {
        Random random = new Random();
        populationMap = new HashMap<>();
        populationMap.put("万寿路街道", 344243 + random.nextInt(1000));
        populationMap.put("永定路街道", 866565 + random.nextInt(1000));
        populationMap.put("羊坊店街道", 123412 + random.nextInt(1000));
        populationMap.put("甘家口街道", 432455 + random.nextInt(1000));
        populationMap.put("八里庄街道", 656775 + random.nextInt(1000));
        populationMap.put("紫竹院街道", 234114 + random.nextInt(1000));
        populationMap.put("北下关街道", 754453 + random.nextInt(1000));
        populationMap.put("北太平庄街道", 123455 + random.nextInt(1000));
        populationMap.put("学院路街道", 143431 + random.nextInt(1000));
        populationMap.put("中关村街道", 723412 + random.nextInt(1000));
        populationMap.put("海淀街道", 859475 + random.nextInt(1000));
        populationMap.put("青龙桥街道", 356485 + random.nextInt(1000));
        populationMap.put("清华园街道", 445856 + random.nextInt(1000));
        populationMap.put("燕园街道", 245633 + random.nextInt(1000));
        populationMap.put("香山街道", 254544 + random.nextInt(1000));
        populationMap.put("清河街道", 956698 + random.nextInt(1000));
        populationMap.put("花园路街道", 536244 + random.nextInt(1000));
        populationMap.put("西三旗街道", 251544 + random.nextInt(1000));
        populationMap.put("马连洼街道", 7758864 + random.nextInt(1000));
        populationMap.put("田村路街道", 525544 + random.nextInt(1000));
        populationMap.put("上地街道", 658544 + random.nextInt(1000));
        populationMap.put("万柳街道", 254411 + random.nextInt(1000));
        populationMap.put("东升街道", 532885 + random.nextInt(1000));
        populationMap.put("曙光街道", 458845 + random.nextInt(1000));
        populationMap.put("温泉街道", 441122 + random.nextInt(1000));
        populationMap.put("四季青街道", 568852 + random.nextInt(1000));
        populationMap.put("西北旺街道", 5645241 + random.nextInt(1000));
        populationMap.put("苏家坨街道", 655452 + random.nextInt(1000));
        populationMap.put("上庄街道", 452111 + random.nextInt(1000));
        permanentPopulationNumber = 3737000 + random.nextInt(10000);
        permanentMigrantPopulationNumber = 2353000 + random.nextInt(10000);
        yearSexMap = new HashMap<>();
        yearSexMap.put("0w", 123 + random.nextInt(100));
        yearSexMap.put("0m", 119 + random.nextInt(100));
        yearSexMap.put("1-4w", 123 + random.nextInt(100));
        yearSexMap.put("1-4m", 119 + random.nextInt(100));
        yearSexMap.put("5-9w", 123 + random.nextInt(100));
        yearSexMap.put("5-9m", 119 + random.nextInt(100));
        yearSexMap.put("10-14w", 1235 + random.nextInt(1000));
        yearSexMap.put("10-14m", 1192 + random.nextInt(1000));
        yearSexMap.put("15-19w", 12314 + random.nextInt(1000));
        yearSexMap.put("15-19m", 15685 + random.nextInt(1000));
        yearSexMap.put("20-24w", 324565 + random.nextInt(10000));
        yearSexMap.put("20-24m", 457869 + random.nextInt(10000));
        yearSexMap.put("25-29w", 120110 + random.nextInt(10000));
        yearSexMap.put("25-29m", 110021 + random.nextInt(10000));
        yearSexMap.put("30-34w", 65324 + random.nextInt(5000));
        yearSexMap.put("30-34m", 63453 + random.nextInt(5000));
        yearSexMap.put("35-39w", 42542 + random.nextInt(5000));
        yearSexMap.put("35-39m", 47869 + random.nextInt(5000));
        yearSexMap.put("40-44w", 45822 + random.nextInt(5000));
        yearSexMap.put("40-44m", 45682 + random.nextInt(5000));
        yearSexMap.put("45-49w", 35457 + random.nextInt(3000));
        yearSexMap.put("45-49m", 36458 + random.nextInt(3000));
        yearSexMap.put("50-54w", 32241 + random.nextInt(3000));
        yearSexMap.put("50-54m", 31445 + random.nextInt(3000));
        yearSexMap.put("55-59w", 29575 + random.nextInt(2000));
        yearSexMap.put("55-59m", 29635 + random.nextInt(2000));
        yearSexMap.put("60-64w", 10242 + random.nextInt(1000));
        yearSexMap.put("60-64m", 10245 + random.nextInt(1000));
        yearSexMap.put("65-69w", 5012 + random.nextInt(500));
        yearSexMap.put("65-69m", 3545 + random.nextInt(500));
        yearSexMap.put("70-74w", 1047 + random.nextInt(100));
        yearSexMap.put("70-74m", 1204 + random.nextInt(100));
        yearSexMap.put("75-79w", 357 + random.nextInt(100));
        yearSexMap.put("75-79m", 369 + random.nextInt(100));
        yearSexMap.put("80-84w", 120 + random.nextInt(100));
        yearSexMap.put("80-84m", 135 + random.nextInt(100));
        yearSexMap.put("85-89w", 23 + random.nextInt(10));
        yearSexMap.put("85-89m", 54 + random.nextInt(10));
        yearSexMap.put("91-95w", 11 + random.nextInt(10));
        yearSexMap.put("91-95m", 10 + random.nextInt(10));
    }

    public AreaPopulationDetailsEntity areaPopulationDetails() {
//        if (Objects.isNull(populationMap)) {
            initPopulationMap();
//        }
        AreaPopulationDetailsEntity areaPopulationDetailsEntity = new AreaPopulationDetailsEntity();
        areaPopulationDetailsEntity.setArea(AREA);
        areaPopulationDetailsEntity.setStreetPopulationInfo(populationMap);
        areaPopulationDetailsEntity.setYearSexInfo(yearSexMap);
        areaPopulationDetailsEntity.setPermanentPopulationNumber(permanentPopulationNumber);
        areaPopulationDetailsEntity.setPermanentMigrantPopulationNumber(permanentMigrantPopulationNumber);
        return areaPopulationDetailsEntity;
    }

    @Override
    public AreaPopulationHealthyEntity areaHealthyInfo() {
        Random random = new Random();
        AreaPopulationHealthyEntity areaPopulationHealthyEntity = new AreaPopulationHealthyEntity();
        areaPopulationHealthyEntity.setAge(30);
        areaPopulationHealthyEntity.setBloodPressure(75 + random.nextInt(10) + "-" + (135 + random.nextInt(10)));
        areaPopulationHealthyEntity.setBloodSugar(3.5f + random.nextInt(10) / 10f + "-" + String.format("%.1f", 5.6f + random.nextInt(10) / 10f));
        areaPopulationHealthyEntity.setBloodFat(LowHighLevelType.getValueByCode(random.nextInt(5)));
        areaPopulationHealthyEntity.setWeightIndex(18 + random.nextInt(10) / 10f + "-" + String.format("%.1f", 24.4f + random.nextInt(10) / 10f));
        areaPopulationHealthyEntity.setHeartRate(55 + random.nextInt(10) + "-" + (95 + random.nextInt(10)));
        areaPopulationHealthyEntity.setCReactiveProtein(0 + random.nextInt(3) / 10f + "-" + String.format("%.1f", 2.9f + random.nextInt(10) / 10f));
        areaPopulationHealthyEntity.setABCInfectiousDiseases(27 + random.nextInt(2));
        areaPopulationHealthyEntity.setReportDisease(113 + random.nextInt(10));
        areaPopulationHealthyEntity.setReportDiseaseRate(120f + random.nextInt(10) / 10f);
        areaPopulationHealthyEntity.setMorbidityDecline(4 + random.nextInt(10) / 10f);
        areaPopulationHealthyEntity.setViralHepatitisDecline(25 + random.nextInt(10) + 10f);
        areaPopulationHealthyEntity.setCrystalliDecline(15 + random.nextInt(10) / 10f);
        areaPopulationHealthyEntity.setScarletFeverDecline(36 + random.nextInt(10) / 10f);
        areaPopulationHealthyEntity.setEpidemicSituationLevel(BadWellLevelType.getValueByCode(random.nextInt(5)));
        return areaPopulationHealthyEntity;

    }
}
