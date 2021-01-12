package com.boraydata.hygiene.common.util;

public class StringUtil {

    public static boolean isNullOrBlank(String string) {
        if (string == null || "".equals(string)) {
            return true;
        }
        return false;
    }

}
