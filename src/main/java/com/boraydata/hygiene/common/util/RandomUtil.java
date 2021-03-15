package com.boraydata.hygiene.common.util;

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
}
