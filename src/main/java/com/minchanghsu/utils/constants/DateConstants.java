package com.minchanghsu.utils.constants;

import java.time.format.DateTimeFormatter;

public class DateConstants {

    // AD date formatter string
    public static final String YMD = "yyyy-MM-dd";
    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMDHMS2 = "yyyy/M/d H:m:s";
    public static final String YMDHMSSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YMDHMSS = "yyyy-MM-dd HH:mm:ss.S";
    public static final String YMDOnly = "yyyyMMdd";
    public static final String YMDwithoutSeparator = "yyyyMMddHHmmss";


    // command formatter string
    public static final String MDHM = "MM/dd HH:mm";
    public static final String HMS = "HH:mm:ss";
    public static final String HM = "HH:mm";
    public static final String HmsOnly = "HHmmss";


    // RC date formatter string
    public static final String RC_YMD = "yyy-MM-dd";
    public static final String RC_YMDHHMMSS = "yyy-MM-dd HH:mm:ss";
    public static final String RC_YMDHMS = "yyy-MM-dd H:m:s";
    public static final String RC_YMDHMSSSS = "yyy-MM-dd HH:mm:ss.SSS";
    public static final String RC_YMDHMSS = "yyy-MM-dd HH:mm:ss.S";

    public static final String RC_YMD_2 = "yyy/MM/dd";
    public static final String RC_YMDHHMMSS_2 = "yyy/MM/dd HH:mm:ss";
    public static final String RC_YMDHMS_2 = "yyy/MM/dd H:m:s";
    public static final String RC_YMDHMSSSS_2 = "yyy/MM/dd HH:mm:ss.SSS";
    public static final String RC_YMDHMSS_2 = "yyy/MM/dd HH:mm:ss.S";

    public static final String RC_YMDOnly = "yyyMMdd";
    public static final String RC_YMDwithoutSeparator = "yyyMMddHHmmss";



    /**
     * 日期格式化成yyyy-MM-dd
     */
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern(YMD);
    /**
     * 日期格式化成HH:mm:ss
     */
    public static final DateTimeFormatter HH_mm_SS = DateTimeFormatter.ofPattern(HMS);
    /**
     * 日期格式化成HH:mm
     */
    public static final DateTimeFormatter HH_mm = DateTimeFormatter.ofPattern(HM);
    /**
     * 日期格式化成yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_mm_SS = DateTimeFormatter.ofPattern(YMDHMS);
    /**
     * 日期格式化成yyyy/MM/dd HH:mm:ss，如2018/04/05 21:50:58
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_mm_SS2 = DateTimeFormatter.ofPattern(YMDHMS2);
    /**
     * 日期格式化成MM/dd HH:mm
     */
    public static final DateTimeFormatter MM_DD_HH_mm = DateTimeFormatter.ofPattern(MDHM);
    /**
     * 日期格式化成yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_mm_SS_MS = DateTimeFormatter.ofPattern(YMDHMSSSS);
    /**
     * 日期格式化成yyyy-MM-dd HH:mm:ss.S
     */
    public static final DateTimeFormatter YYYY_MM_DD_HH_mm_SS_S = DateTimeFormatter.ofPattern(YMDHMSS);
    /**
     * 日期格式化成yyyyMMddHHmmss
     */
    public static final DateTimeFormatter DATETIME_FORMAT_NO_SLASH = DateTimeFormatter.ofPattern(YMDwithoutSeparator);
    /**
     * 日期格式化成yyyyMMdd
     */
    public static final DateTimeFormatter DATE_FORMAT_NO_SLASH = DateTimeFormatter.ofPattern("yyyyMMdd");
    /**
     * 日期格式化成HHmmss
     */
    public static final DateTimeFormatter TIME_FORMAT_NO_SLASH = DateTimeFormatter.ofPattern("HHmmss");


    // =======  RC date formatter object
    /**
     * 日期格式化成yyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter RC_YYY_MM_DD_HH_mm_SS = DateTimeFormatter.ofPattern(RC_YMDHHMMSS);

    // =======  RC date formatter object
    /**
     * 日期格式化成yyy/MM/dd HH:mm:ss
     */
    public static final DateTimeFormatter RC_YYY_MM_DD_HH_mm_SS_2 = DateTimeFormatter.ofPattern(RC_YMDHHMMSS_2);
}
