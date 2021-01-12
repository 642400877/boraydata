package com.boraydata.hygiene.common.util;

import java.util.Collection;

public class CollectionUtil {

    public static boolean isNullOrEmpty(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }

}
