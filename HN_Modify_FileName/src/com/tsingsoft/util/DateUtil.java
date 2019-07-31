package com.tsingsoft.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {

    /**
     * 获取当天日期
     *
     * @param pattern 日期格式
     * @return
     */
    public static String getCurrDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String strCurrDate = sdf.format(new Date());
        return strCurrDate;
    }
    /**
     * 获得当前时间最近的一个点的时间
     * @param interval 间隔15分钟或者其他时间
     * @return
     */
    public static Date getLastPointTime(int interval){
        Calendar ca = Calendar.getInstance();
        int mi = ca.get(Calendar.MINUTE);
        ca.set(Calendar.MINUTE,  mi / interval * interval);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);
        return new Date(ca.getTimeInMillis());
    }

    public static String toFormatString(Date date, String pattern) {
        String str;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            str = sdf.format(date);
        } catch (Exception e) {
            str = null;
        }
        return str;
    }

    /**
     * Makes a Date from separate Strings for year, month, day, hour, minute,
     * and second.
     *
     * @param yearStr
     *            The year String
     * @param monthStr
     *            The month String
     * @param dayStr
     *            The day String
     * @param hourStr
     *            The hour String
     * @param minuteStr
     *            The minute String
     * @param secondStr
     *            The second String
     * @return A Date made from separate Strings for year, month, day, hour,
     *         minute, and second.
     */
    public static java.util.Date toDate(String yearStr, String monthStr,
                                        String dayStr, String hourStr, String minuteStr, String secondStr) {
        int month, day, year, hour, minute, second;

        try {
            month = Integer.parseInt(monthStr);
            day = Integer.parseInt(dayStr);
            year = Integer.parseInt(yearStr);
            hour = Integer.parseInt(hourStr);
            minute = Integer.parseInt(minuteStr);
            second = Integer.parseInt(secondStr);
        } catch (Exception e) {
            return null;
        }
        return toDate(year, month, day, hour, minute, second);
    }
    /**
     * Makes a Date from separate ints for month, day, year, hour, minute, and
     * second.
     *
     * @param year
     *            The year int
     * @param month
     *            The month int
     * @param day
     *            The day int
     * @param hour
     *            The hour int
     * @param minute
     *            The minute int
     * @param second
     *            The second int
     * @return A Date made from separate ints for year, month, day, hour,
     *         minute, and second.
     */
    public static Date toDate(int year, int month, int day, int hour,
                                        int minute, int second) {
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.set(year, month - 1, day, hour, minute, second);
            calendar.set(Calendar.MILLISECOND, 0);
        } catch (Exception e) {
            return null;
        }
        return new java.util.Date(calendar.getTime().getTime());
    }

    public static Date addDays(java.util.Date date, int amount) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, amount);
        return ca.getTime();
    }
    public static String DateToString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(date);
    }


    public static String addDays(String ymd, int amount) {
        Date date = toDate(ymd.substring(0,4), ymd.substring(4,6), ymd.substring(6,8), "0", "0", "0");
        return toFormatString(addDays(date, amount), "yyyyMMdd") ;
    }


    public static void main(String[] args) {
        String time = DateUtil.DateToString(
                DateUtil.getLastPointTime(15)).substring(8, 12);
        System.out.println(time);
    }
}
