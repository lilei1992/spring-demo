package com.fss.springdemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:27
 **/
public class DateUtil {
    public DateUtil() {
    }

    public static String getGmtTime(Date d) {
        SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format(d);
    }

    public static Date getCstDate(String s) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.parse(s);
    }

    public static void main(String[] a) throws ParseException {
        String s = getGmtTime(new Date());
        System.out.println(s);
        System.out.println(new Date());
        System.out.println(getCstDate(s));
    }
}