package com.boraydata.hygiene.common.type;

public enum BadWellLevelType {

    BAD(0, "差"),
    LITTLE_BAD(1, "较差"),
    NORMAL(2, "正常"),
    LITTLE_WELL(3, "较好"),
    WELL(4, "好");

    Integer code;
    String value;

    BadWellLevelType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        BadWellLevelType[] badWellLevelTypes = BadWellLevelType.values();
        for (int i = 0; i < badWellLevelTypes.length; i++) {
            if (badWellLevelTypes[i].code == code) {
                return badWellLevelTypes[i].value;
            }
        }
        return null;
    }


}
