package com.yudachi.citylife.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {


    /**
     * 将2019-06-03T16:00:00.000Z日期格式转换为2019-06-03 16:00:00格式
     *
     * @param oldDate
     * @return: java.lang.String
     **/
    public static String dealDateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            oldDate = oldDate.replace("Z", " UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return df2.format(date1);
    }

    /**
     * 将2019-06-03T16:00:00.000Z日期格式转换为2019-06-03格式
     *
     * @param oldDate
     * @return: java.lang.String
     **/
    public static String dealDateFormatNotHHMMSS(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            oldDate = oldDate.replace("Z", " UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return df2.format(date1);
    }

    /**
     * 将2019-06-03T16:00:00.000Z日期格式转换为2019格式
     *
     * @param oldDate
     * @return: java.lang.String
     **/
    public static String dealDateFormatNotMMddHHmmss(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            oldDate = oldDate.replace("Z", " UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return df2.format(date1);
    }

    /**
     * 将2019-06-03T16:00:00.000Z日期格式转换为2019-06-03 16:00:00格式
     *
     * @param oldDateStr
     * @return
     */
    public static Date transferDateFormat(String oldDateStr) {
        if (StringUtils.isBlank(oldDateStr)) {
            return null;
        }
        Date date = null;
        Date date1 = null;
        String dateStr = null;
        try {
            //是空格+UTC
            dateStr = oldDateStr.replace("Z", " UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            date1 = df.parse(dateStr);
            SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date = df1.parse(date1.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * @param dateString Thu May 18 2017 00:00:00 GMT+0800 (中国标准时间)
     * @return 年月日;
     */
    public static Date parseTime(String dateString) {
        dateString = dateString.replace("GMT", "").replaceAll("\\(.*\\)", "");
        //将字符串转化为date类型，格式2016-10-12
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.ENGLISH);
        Date dateTrans = null;
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTrans;
    }

    /**
     * @param datdString "Tue Jul 12 12:10:11 GMT+08:00 2016";
     * @return 时分秒
     */
    public static String parseHour(String datdString) {

        datdString = datdString.replace("GMT", "").replaceAll("\\(.*\\)", "");
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.ENGLISH);
        Date dateTrans = null;
        try {
            dateTrans = format.parse(datdString);
            return new SimpleDateFormat("HH:mm:ss").format(dateTrans);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datdString;
    }
}