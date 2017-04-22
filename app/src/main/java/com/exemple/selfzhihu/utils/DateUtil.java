package com.exemple.selfzhihu.utils;

/**
 * Created by Jasper on 2017/4/22.
 */

public class DateUtil {
    public static String getFormatDate(String date){
        String formatDate;
        String year = date.substring(0,4);
        String month = date.substring(4,6);
        String day = date.substring(6,8);
        formatDate = year+"年"+month+"月"+day+"日";
        return formatDate;
    }
}
