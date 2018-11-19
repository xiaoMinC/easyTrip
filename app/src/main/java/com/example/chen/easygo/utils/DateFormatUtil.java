package com.example.chen.easygo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {
	public static String getNowTime() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sFormat = new SimpleDateFormat(pattern);
		Date date = new Date();
		return sFormat.format(date);
	}

	//获取前一年的年份
	public static String getLastYear(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date date = new Date();
		return format.format(date);
	}

	public static String getStringDate(Long date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public static String formatStringDate(Long date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 获取当前年月日
	 * @return
	 */
	public static String getCurrentDate() {
		  Calendar c = Calendar.getInstance();
		  c.setTimeInMillis(System.currentTimeMillis());
		  Date d = c.getTime();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  return sdf.format(d);
	}

	/**
	 * 获取当前月份第一天
	 * @return
	 */
	public static String getCurrentFirDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_YEAR, 1);
		return sdf.format(cal.getTime());
	}

	/**
	 * 获取当前年--月
	 * @return
	 */
	public static String getCurrentYM() {
		  Calendar c = Calendar.getInstance();
		  c.setTimeInMillis(System.currentTimeMillis());
		  Date d = c.getTime();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
		  return sdf.format(d);
   }

	/**
	 * 获取当前年--月--日--时--分--秒
	 * @return
	 */
	public static String getCurrentTime() {
		  Calendar c = Calendar.getInstance();
		  c.setTimeInMillis(System.currentTimeMillis());
		  Date d = c.getTime();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  return sdf.format(d);
		  
   }


	public static Long timeStrToSecond(String time) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Long second = format.parse(time).getTime();
			return second;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1l;
	}

	/**
	 * 获取月
	 * @return
	 */
	public static String getCurrentMonth() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		Date d = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(d);

	}

}
