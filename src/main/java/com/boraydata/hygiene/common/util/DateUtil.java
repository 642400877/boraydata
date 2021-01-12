package com.boraydata.hygiene.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static Date formatChange(String date) throws ParseException {
        return formatChange(date, YYYY_MM_DD);
    }

    public static Date formatChange(String date, String format) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat(format);
        return sdf1.parse(date);
    }

}
