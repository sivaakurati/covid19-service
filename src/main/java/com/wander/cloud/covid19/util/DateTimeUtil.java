/**
 * 
 */
package com.wander.cloud.covid19.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author SIVA KUMAR
 */
public class DateTimeUtil {

	private static Logger log = LoggerFactory.getLogger(DateTimeUtil.class);
	private static final DateTimeUtil instance = new DateTimeUtil();
	private DateTimeUtil() {}

	public static DateTimeUtil getInstance() {
		return instance;
	}

	public String convertTimestamp2Date(Timestamp timestamp) {
		String dateStr = null;
		if (timestamp != null) {
			Date date = new Date(timestamp.getTime());
			SimpleDateFormat formatter = new SimpleDateFormat(Constants.MM_DD_YYYY_DATE_FORMAT);
			dateStr = formatter.format(date);
		}
		return dateStr;
	}

	public java.sql.Date convertString2SqlDate(String strDate) {
		DateFormat formatter = new SimpleDateFormat(Constants.YYYY_MM_DD_DATE_FORMAT);
		java.sql.Date convertedDate = null;
		try {
			convertedDate = (java.sql.Date) formatter.parse(strDate);
		} catch (ParseException e) {
			String formatErrorMessage = StringUtil.getInstance().formattedLogMessage(Constants.EXCEPTION_FOR, Constants.DOUBLE_UNIQUE_LOG);
			log.error(formatErrorMessage, new Throwable().getStackTrace()[0].getMethodName(), e.getMessage());
		}
		return convertedDate;
	}

	public java.util.Date convertString2UtilDate(String strDate) {
		DateFormat formatter = new SimpleDateFormat(Constants.YYYY_MM_DD_DATE_FORMAT);
		java.util.Date convertedDate = null;
		try {
			convertedDate = formatter.parse(strDate);
		} catch (ParseException e) {
			String formatErrorMessage = StringUtil.getInstance().formattedLogMessage(Constants.EXCEPTION_FOR, Constants.DOUBLE_UNIQUE_LOG);
			log.error(formatErrorMessage, new Throwable().getStackTrace()[0].getMethodName(), e.getMessage());
		}
		return convertedDate;
	}

	public java.sql.Time convertString2Time(String strTime) {
		DateFormat formatter = new SimpleDateFormat(Constants.HH_MM_TIME_FORMAT);
		java.sql.Time convertedTime = null;
		try {
			convertedTime = new java.sql.Time(formatter.parse(strTime).getTime());
		} catch (ParseException e) {
			String formatErrorMessage = StringUtil.getInstance().formattedLogMessage(Constants.EXCEPTION_FOR, Constants.DOUBLE_UNIQUE_LOG);
			log.error(formatErrorMessage, new Throwable().getStackTrace()[0].getMethodName(), e.getMessage());
		}
		return convertedTime;
	}

	public java.sql.Timestamp convertUtilDate2Timestamp() {
		return convertUtilDate2Timestamp(new java.util.Date());
	}

	public java.sql.Timestamp convertUtilDate2Timestamp(java.util.Date utilDate) {
		return new Timestamp(utilDate.getTime());
	}

	public Date convertGMT2ISTDateTime(String datetime) {
		Date date = null;
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
		DateTime dTime = parser.parseDateTime(datetime);
		DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
		String strDate = formatter.print(dTime);
		DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			String formatErrorMessage = StringUtil.getInstance().formattedLogMessage(Constants.EXCEPTION_FOR, Constants.DOUBLE_UNIQUE_LOG);
			log.error(formatErrorMessage, new Throwable().getStackTrace()[0].getMethodName(), e.getMessage());
		}
		return date;
	}

	public Date convertGMT2ISTDate(String datetime) {
		Date date = null;
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
		DateTime dTime = parser.parseDateTime(datetime);
		DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
		String strDate = formatter.print(dTime);
		DateFormat dateFormat = new SimpleDateFormat(Constants.DD_MMM_YYYY_DATE_FORMAT);
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			String formatErrorMessage = StringUtil.getInstance().formattedLogMessage(Constants.EXCEPTION_FOR, Constants.DOUBLE_UNIQUE_LOG);
			log.error(formatErrorMessage, new Throwable().getStackTrace()[0].getMethodName(), e.getMessage());
		}
		return date;
	}

	public Date convertGMTTime2ISTDate(String datetime) {
		Date date = null;
		DateTimeFormatter parser = ISODateTimeFormat.dateTime();
		DateTime dTime = parser.parseDateTime(datetime);
		DateTimeFormatter formatter = DateTimeFormat.mediumDateTime();
		String strDate = formatter.print(dTime);
		DateFormat dateFormat = new SimpleDateFormat(Constants.ISO_DATE_TIME_FORMAT);
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			String formatErrorMessage = StringUtil.getInstance().formattedLogMessage(Constants.EXCEPTION_FOR, Constants.DOUBLE_UNIQUE_LOG);
			log.error(formatErrorMessage, new Throwable().getStackTrace()[0].getMethodName(), e.getMessage());
		}
		return date;
	}

	public String convertGMT2ISTDateTimestamp(String datetime) {
		return ISODateTimeFormat.dateTime().parseDateTime(datetime).toString();
	}

	public String convertSqlDate2String(String sqlDate) {
		String strDate = null;
		try {
			Date date = new SimpleDateFormat(Constants.YYYY_MM_DD_DATE_FORMAT).parse(sqlDate);
			strDate = new SimpleDateFormat(Constants.MM_DD_YYYY_DATE_FORMAT).format(date);
		} catch (ParseException e) {
			String formatErrorMessage = StringUtil.getInstance().formattedLogMessage(Constants.EXCEPTION_FOR, Constants.DOUBLE_UNIQUE_LOG);
			log.error(formatErrorMessage, new Throwable().getStackTrace()[0].getMethodName(), e.getMessage());
		}
		return strDate;
	}

	public Date convertSqlDate2UtilDate(String sqlDate) {
		String[] strDate = convertSqlDate2String(sqlDate).split(Constants.SLASH);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(strDate[2]), Integer.parseInt(strDate[0]) - 1, Integer.parseInt(strDate[1]));
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

	public List<Date> getWeekStartNEndDates() {
		List<Date> weekDates = new ArrayList<>();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek();
		calendar.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		weekDates.add(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, 6);
		weekDates.add(calendar.getTime());
		return weekDates;
	}

	public List<Date> getMonthStartNEndDates() {
		List<Date> weekDates = new ArrayList<>();
		LocalDate today = LocalDate.now();
		weekDates.add(Date.from(today.withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		weekDates.add(Date
				.from(today.withDayOfMonth(today.lengthOfMonth()).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		return weekDates;
	}

	public String convertUtilDateToStringFormat(Date date) {
		DateFormat formatter = new SimpleDateFormat(Constants.DAY_WITH_DATE_FORMAT);
		return formatter.format(date);
	}
}
