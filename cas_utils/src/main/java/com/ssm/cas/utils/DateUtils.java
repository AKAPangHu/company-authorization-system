package com.ssm.cas.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: 胖虎
 * @date: 2019/5/24 10:39
 **/

public class DateUtils {
    public static String dateToString(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
