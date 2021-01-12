package com.boraydata.hygiene.common.type;

public enum DeleteType {
    NO_DELETE(0, "未删除"),
    DELETE(1, "已删除");

    private Integer code;
    private String value;

    DeleteType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        DeleteType[] deleteTypes = DeleteType.values();
        for (int i = 0; i < deleteTypes.length; i++) {
            if (deleteTypes[i].code == code) {
                return deleteTypes[i].value;
            }
        }
        return null;
    }
}
