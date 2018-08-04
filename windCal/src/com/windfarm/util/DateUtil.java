package com.windfarm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 当前日期基础上减少一天
	 */
	public static String setDateCutOneDay(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate;
		try {
			beginDate = sdf.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(beginDate);
			c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
			Date endDate = c.getTime();
			String forecasttime = sdf.format(endDate);
			return forecasttime;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
