package com.boraydata.hygiene.common.util;

import com.boraydata.hygiene.common.excention.BusinessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {

    public static int randomInt(Integer source, int floatIndex) {
        Double num = Math.random();
        return (int)(source + (source * floatIndex * num) / 100);
    }

    public static float randomFloat(Float source, int floatIndex) {
       Double num = Math.random();
       return (float)(source + (source * floatIndex * num) / 100);
    }

    public static Double randomDouble(Double source, int floatIndex) {
        Double num = Math.random();
        return (source + (source * floatIndex * num) / 100);
    }

    public static Long randomLong(Long source, int floatIndex) {
        Double num = Math.random();
        return (long)(source + (source * floatIndex * num) / 100);
    }

//    public static List<Float> splitRandom(int total, int size, Float min, Float max) {
//        if (min * size > total) {
//            throw new BusinessException("最小值*大小大于总值");
//        }
//        Random random = new Random();
//        List<Float> list = new ArrayList<>(size);
//
//    }
}
