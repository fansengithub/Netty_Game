package com.mmall.mypayutil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
	/*
	 * 获取2017-01-02 12:00:00这样的字符串时间
	 */
	public static String getNowTime()
	{
		return sdf1.format(new Date());
	}
	/**
	 * 获取系统当前timestamp时间戳
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 获取系统当前date时间戳
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	public static void main(String[] args) throws ParseException {
		// System.out.println(getCurrentDate());
		// System.out.println(System.currentTimeMillis());
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(getCurrentDate().getTime());
		// System.out.println(DateUtil.strToDate("2015-11-25 17:05:36"));
		// Timestamp ts = new Timestamp(System.currentTimeMillis());
		// System.out.println(DateUtil.DateToStr(ts, "MM-dd"));
		// System.out.println(getYesterday());
		// System.out.println(getYesterdayMMdd());
		// System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
		// .format(getYesterDay()));

		// System.out.println(getHour24());

		System.out.println(getCurrentDateStryyyyMMddHHmmss());
	}

	/**
	 * 获取当前月日格式 03-09
	 * 
	 * @return
	 */
	public static String getCurrentMonthDay() {
		Calendar now = Calendar.getInstance();
		//int year = now.get(Calendar.YEAR);
		int month = (now.get(Calendar.MONTH) + 1);
		int day = now.get(Calendar.DAY_OF_MONTH);
		return String.format("%02d", month) + "-" + String.format("%02d", day);
	}

	/**
	 * 字符串转日期
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(str);
		return date;
	}

	/**
	 * 获取昨天年-月-日yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		// cal.add(5, -1);
		String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal
				.getTime());
		return yesterday;
	}

	/**
	 * 获取当前时间对应的昨天时间
	 * 
	 * @return
	 */
	public static Date getYesterDay() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();

	}

	/**
	 * 获取当天日期年-月-日yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getToday() {
		Calendar cal = Calendar.getInstance();
		String today = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return today;
	}

	/**
	 * 获取昨天年-月-日yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getYesterdayMMdd() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("MM-dd").format(cal.getTime());
		return yesterday;
	}

	/**
	 * 字符串转日期
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date strToDateTime(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(str);
		return date;
	}

	/**
	 * 获取格式化的当前时间字符串
	 * 
	 * @return
	 */
	public static String getCurrentDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date(System.currentTimeMillis());
		String date = sdf.format(currentTime);
		return date;
	}

	/**
	 * 获取格式化的当前时间字符串
	 * 
	 * @return
	 */
	public static String getCurrentDateStryyyyMMddHHmmss() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date currentTime = new Date(System.currentTimeMillis());
		String date = sdf.format(currentTime);
		return date;
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String DateToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String str = sdf.format(date);
		return str;
	}

	public static String DateToStr(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String str = sdf.format(date);
		return str;
	}

	public static String DateToStrCommonFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		return str;
	}

	/**
	 * 指定字符串日期转换成指定字符串日期
	 * 
	 * @param str
	 * @throws ParseException
	 */
	public static String getFormatDate(String str) throws ParseException {
		Date date = strToDate(str);
		return DateToStr(date);
	}

	/**
	 * 获取当前时间是周几
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekFromDate(Date date) {
		// SimpleDateFormat sdf = new SimpleDateFormat("星期F");
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String week = sdf.format(date);
		return week;
	}

	/**
	 * 字符串日期中获取周几
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static String getWeekFromStr(String str) throws ParseException {
		Date date = strToDate(str);
		return getWeekFromDate(date);
	}

	/**
	 * 获取时分字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getHourMinute(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String str = sdf.format(date);
		return str;
	}

	/**
	 * 获取时分字符串
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String getHourMinute(String str) throws ParseException {
		Date date = strToDate(str);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String result = sdf.format(date);
		return result;
	}

	/**
	 * 获取当天零时时间
	 * 
	 * @return
	 */
	public static Date getTodayZero() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取当前小时数，24
	 * 
	 * @return
	 */
	public static int getHour24() {

		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		return hour;
	}

	// public static void main(String[] args) {
	//
	// }

}
