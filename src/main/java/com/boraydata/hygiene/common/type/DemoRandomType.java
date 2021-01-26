package com.boraydata.hygiene.common.type;

import com.boraydata.hygiene.common.temp.DemoRandomTypeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DemoRandomType {

    POPULATION_BIRTH_NUMBER("birthNumber", "population", "出生人口数量", 0, 100, false, 0),
    POPULATION_BIRTH_RATE("birthRate", "population", "出生率", 0, 1000, true, 2),
    POPULATION_MORTALITY_NUMBER("mortalityNumber", "population", "死亡人口数量", 0, 100, false, 0),
    POPULATION_MORTALITY("mortality", "population", "死亡率", 0, 1000, true, 2),
    POPULATION_MIGRATION_INDEX("migrationIndex", "population", "人口迁移指数", 0, 1000, true, 2),
    POPULATION_DENSITY("populationDensity", "population", "人口稠密度", 0, 1000, true, 2),
    ECONOMICS_GDP("gdp", "economics", "国民生产总值", 100000000, Integer.MAX_VALUE, true, 2),
    ECONOMICS_CPI("cpi", "economics", "物价指数", 0, 1000, true, 2),
    ECONOMICS_SOCIAL_FIXED_ASSETS("socialFixedAssets", "economics", "社会固定资产", 10000,  Integer.MAX_VALUE, true, 2),
    ECONOMICS_REVENUE("revenue", "economics", "财政收入", 1000000, Integer.MAX_VALUE, true, 2),
    ECONOMICS_BUDGET("budget", "economics", "财政预算", 1000000, Integer.MAX_VALUE, true, 2),
    ECONOMICS_SPEED_INCREASE("speedIncrease", "economics", "增速", 0, 1000, true, 2),
    POPULATION_NUMBER("populationNumber", "population", "人口数量", 100000, 999999, false, 0),
    MATERIAL_DISTRIBUTION("materialDistribution", "material", "物资分布", 100000, 999999, false, 0),
    MATERIAL_RESERVES("materialReserves", "material", "物资储量", 100000, 999999, false, 0);

    String code;
    String type;
    String name;
    Integer min;
    Integer max;
    Boolean needFloat;
    Integer floatNumber;

    DemoRandomType(String code, String type, String name, Integer min, Integer max, Boolean needFloat, Integer floatNumber) {
        this.code = code;
        this.type = type;
        this.name = name;
        this.min = min;
        this.max = max;
        this.needFloat = needFloat;
        this.floatNumber = floatNumber;
    }

    public static List<DemoRandomType> getDemoRandomTypeByType(String type) {
        List<DemoRandomType> demoRandomTypeList = new ArrayList<>();
        DemoRandomType[] demoRandomTypes = DemoRandomType.values();
        for (int i = 0; i < demoRandomTypes.length; i++) {
            if (demoRandomTypes[i].type.equals(type)) {
                demoRandomTypeList.add(demoRandomTypes[i]);
            }
        }
        return demoRandomTypeList;
    }

    public static Map<String, DemoRandomTypeClass> getDemoRandomTypeMapByType(String type) {
        Map<String, DemoRandomTypeClass> demoRandomTypeMap = new HashMap<>();
        DemoRandomType[] demoRandomTypes = DemoRandomType.values();
        for (int i = 0; i < demoRandomTypes.length; i++) {
            if (demoRandomTypes[i].type.equals(type)) {
                DemoRandomTypeClass demoRandomTypeClass = new DemoRandomTypeClass();
                demoRandomTypeClass.setMax(demoRandomTypes[i].max);
                demoRandomTypeMap.put(demoRandomTypes[i].code,demoRandomTypeClass);
            }
        }
        return demoRandomTypeMap;
    }
}
