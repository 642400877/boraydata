package com.boraydata.hygiene.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtil {

    public static boolean isNullOrEmpty(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    public static <T> List<T> sublistLoop(List<T> list, int index, int size) {
        if (index > list.size()) {
            index = index % list.size();
        }
        if (index + size < list.size()) {
            return list.subList(index, index + size);
        } else {
            List<T> objectList = new ArrayList<>(size);
            objectList.addAll(list.subList(index, list.size()));
            objectList.addAll(list.subList(0, size - (list.size() - index)));
            return objectList;
        }
    }

}
