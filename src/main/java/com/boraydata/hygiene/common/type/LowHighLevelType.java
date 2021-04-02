package com.boraydata.hygiene.common.type;

public enum LowHighLevelType {

    LOW(0, "低"),
    LITTLE_LOW(1, "偏低"),
    NORMAL(2, "正常"),
    LITTLE_HIGH(3, "偏高"),
    HIGH(4, "高");

    Integer code;
    String value;

    LowHighLevelType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        LowHighLevelType[] levelTypes = LowHighLevelType.values();
        for (int i = 0; i < levelTypes.length; i++) {
            if (levelTypes[i].code == code) {
                return levelTypes[i].value;
            }
        }
        return null;
    }

}
