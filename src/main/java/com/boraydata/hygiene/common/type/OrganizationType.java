package com.boraydata.hygiene.common.type;

public enum OrganizationType {

    WORK(0, "出勤"),
    FREE(1, "待命");

    private Integer code;
    private String value;

    OrganizationType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        OrganizationType[] organizationTypes = OrganizationType.values();
        for (int i = 0; i < organizationTypes.length; i++) {
            if (organizationTypes[i].code == code) {
                return organizationTypes[i].value;
            }
        }
        return null;
    }

}
