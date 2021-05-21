package com.zj.settings.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author zhoujian
 */
public class DateUtil {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getDate(){
        return SIMPLE_DATE_FORMAT.format(new Date());
    }
}
