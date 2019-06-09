package com.ssm.cas.utils;

import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 胖虎
 * @date: 2019/5/24 10:39
 **/

public class DateUtils {

    private final DateUtils dateUtils = new DateUtils();

    @Bean
    public DateUtils getDateUtils() {
        return dateUtils;
    }

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
