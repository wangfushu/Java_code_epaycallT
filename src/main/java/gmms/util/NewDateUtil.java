package gmms.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewDateUtil {

	/**
	 * GIS云台控制，计算云台操作时间
	 */
	public static void main(String[] args) {
//		long second = getSecond(fromDateStringToDate("2013-02-27 08:00:00"));
//		System.out.println("当前系统时间  - 登录时间  = "+second+"秒");
//		Integer date = fromDateStringToDate("2016-08-13 20:38:02.000", "2016-08-13 20:38:01.000");
//		System.out.println(date);
//		System.out.println(fromDateStringToDate("2015-01-25 09:12:09"));
		System.out.println(NewDateUtil.fromDateStringToString("2016-08-14 21:03:00.000"));
	}
	
	@SuppressWarnings("unused")
	public static long getSecond(Date endDate){
		// 当前系统时间
		long startT = fromDateStringToLong(dqsj());
		
		//时间转字符串
		String end = fromDateDateToString(endDate);
		
		// 获取数据库时间
		long endT = fromDateStringToLong(end);
		
		// 共计秒数
		long ss = (startT - endT) / (1000);
		
		// 共计分钟数
		int MM = (int) ss / 60;
		
		// 共计小时数
		int hh = (int) ss / 3600;
		
		// 共计天数
		int dd = (int) hh / 24;
		
//		System.out.println("共" + dd + "天" + "\t" + "准确时间是：" + hh + " 小时 "
//				+ "\t" + MM + " 分钟" + "\t" + +ss + " 秒  " + "\t"+ ss
//				* 1000 + " 毫秒");
		return ss;
	}
	
	/**
	 * 字符串转长整型
	 * @param inVal
	 * @return
	 */
	public static long fromDateStringToLong(String inVal) {
		// 此方法计算时间毫秒
		Date date = null;
		// 定义时间类型
		SimpleDateFormat inputFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			date = inputFormat.parse(inVal);
			// 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date.getTime();
		// 返回毫秒数
	}
	
	/**
	 * 时间转字符串
	 * @param inVal
	 * @return
	 */
	public static String fromDateDateToString(Date inVal) {
		// 此方法计算时间毫秒
		String date = null;
		// 定义时间类型
		SimpleDateFormat inputFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			date = inputFormat.format(inVal);
			// 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
		// 返回毫秒数
	}
	
	/**
	 * 时间转字符串(格式化到年月日)
	 * @param inVal
	 * @return
	 */
	public static String fromDayDateToString(Date inVal) {
		// 此方法计算时间毫秒
		String date = null;
		// 定义时间类型
		SimpleDateFormat inputFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		try {
			date = inputFormat.format(inVal);
			// 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
		// 返回毫秒数
	}
	
	/**
	 * 字符串转时间
	 * @param textTime
	 * @return
	 */
	public static Date fromDateStringToDate(String textTime) {
		if(StringUtils.isNullBlank(textTime)){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = df.parse(textTime);
			// 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
		
		// 返回转换后的时间
	}
	
	/**
	 * 字符串转时间
	 * @param textTime
	 * @return
	 */
	public static Date fromDateStringToDateYmd(String textTime) {
		if(StringUtils.isNullBlank(textTime)){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = df.parse(textTime);
			// 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
		
		// 返回转换后的时间
	}
	
	/**
	 * 字符串转字符串时间格式
	 * @param textTime
	 * @return
	 */
	public static String fromDateStringToString(String textTime) {
		if(StringUtils.isNullBlank(textTime)){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String strDate = new String();
		try {
			date = df.parse(textTime);
			strDate = df.format(date);
			// 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strDate;
		
		// 返回转换后的时间
	}
	
	/**
	 * 时间转时间格式
	 * @param d
	 * @return
	 */
	public static Date fromDateDateToDate(Date d) {
		if(null == d){
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = new String();
		Date date = new Date();
		try {
			strDate = df.format(d);
			date = df.parse(strDate);
			// 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
		
		// 返回转换后的时间
	}
	
	/**
	 * 比较时间大小 
	 * @param textStartTime
	 * @param textEndTime
	 * @return
	 */
	public static Integer fromDateStringToDate(String textStartTime, String textEndTime){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try
		{
			c1.setTime(df.parse(textStartTime));
			c2.setTime(df.parse(textEndTime));
		}catch(ParseException e){
//			System.err.println("格式不正确");
		}
			int result = c1.compareTo(c2);
		if(result == 0){
//			System.out.println("c1相等c2");
		}else if(result < 0){
//			System.out.println("c1小于c2");
		}else{
//			System.out.println("c1大于c2");
		}
		return result;
	}
	
	/**
	 * 比较时间大小(格式化到年月日)
	 * @param textStartTime
	 * @param textEndTime
	 * @return
	 */
	public static Integer timeComparisonYearMonthDay(String textStartTime, String textEndTime){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		try
		{
			start.setTime(df.parse(textStartTime));
			end.setTime(df.parse(textEndTime));
		}catch(ParseException e){
			System.err.println("格式不正确");
		}
		
		int result = start.compareTo(end);
		
		if(result == 0){
//			System.out.println("格式化到年月日：c1相等c2");
		}else if(result < 0){
//			System.out.println("格式化到年月日：c1小于c2");
		}else{
//			System.out.println("格式化到年月日：c1大于c2");
		}
		return result;
	}
	
	/**
	 * 比较时间大小(格式化到年月)
	 * @param textStartTime
	 * @param textEndTime
	 * @return
	 */
	public static Integer timeComparisonYearMonth(String textStartTime, String textEndTime){
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try
		{
			c1.setTime(df.parse(textStartTime));
			c2.setTime(df.parse(textEndTime));
		}catch(ParseException e){
			System.err.println("格式不正确");
		}
			int result = c1.compareTo(c2);
		if(result == 0){
//			System.out.println("格式化到年月：c1相等c2");
		}else if(result < 0){
//			System.out.println("格式化到年月：c1小于c2");
		}else{
//			System.out.println("格式化到年月：c1大于c2");
		}
		return result;
	}
	
	@SuppressWarnings("deprecation")
	private static String dqsj() {
		// 此方法用于获得当前系统时间（格式类型2007-11-6 15:10:58）
		Date date = new Date();
		// 实例化日期类型
		String today = date.toLocaleString();
		// 获取当前时间
//		System.out.println("获得当前系统时间 ：" + today);
		// 显示
		return today;
		// 返回当前时间
	}
	/**
	 * 传入时间格式，当前时间加减天数，返回时间
	 * @param dateFormat
	 * @param day
	 */
	public static Date getCountDateFormatDate(String dateFormat, int day){
		SimpleDateFormat dft = new SimpleDateFormat(dateFormat);
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - day);
		Date endDate = null;
		try {
			endDate = dft.parse(dft.format(date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return endDate;
	}
	
	/**
	 * 传入时间格式，当前时间加减天数，返回字符串
	 * @param dateFormat
	 * @param day
	 */
	public static String getCountDateFormatStr(String dateFormat, int day){
		SimpleDateFormat dft = new SimpleDateFormat(dateFormat);
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - day);
		String endDate = null;
		try {
			endDate = dft.format(date.getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return endDate;
	}
	
	/**
	 * 得到两个日期之间的天数
	 * @param dateFormat
	 * @param strDate1
	 * @param strDate2
	 * @return
	 */
	public static int getDays(String dateFormat, String strDate1, String strDate2) {
		// 天数
		int days = 0;
		try {
			// 时间转换类
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date date1 = sdf.parse(strDate1);
			Date date2 = sdf.parse(strDate2);
			// 将转换的两个时间对象转换成Calendard对象
			Calendar can1 = Calendar.getInstance();
			can1.setTime(date1);
			Calendar can2 = Calendar.getInstance();
			can2.setTime(date2);
			// 拿出两个年份
			int year1 = can1.get(Calendar.YEAR);
			int year2 = can2.get(Calendar.YEAR);
			Calendar can = null;
			// 如果can1 < can2
			// 减去小的时间在这一年已经过了的天数
			// 加上大的时间已过的天数
			if (can1.before(can2)) {
				days -= can1.get(Calendar.DAY_OF_YEAR);
				days += can2.get(Calendar.DAY_OF_YEAR);
				can = can1;
			} else {
				days -= can2.get(Calendar.DAY_OF_YEAR);
				days += can1.get(Calendar.DAY_OF_YEAR);
				can = can2;
			}
			for (int i = 0; i < Math.abs(year2 - year1); i++) {
				// 获取小的时间当前年的总天数
				days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
				// 再计算下一年。
				can.add(Calendar.YEAR, 1);
			}

			// System.out.println("天数差："+days);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return days;

	}
	
	/**
	 * 分钟转换成时、分
	 * @param min
	 * @return
	 */
	public static String minConvertDayHourMin(Float min) {
		String html = "0分";
		if (null != min) {
			Float m = (Float) min;
			String format;
			Object[] array;
			Integer days = (int) (m / (60 * 24));
			Integer hours = (int) (m / (60) - days * 24);
			Integer minutes = (int) (m - hours * 60 - days * 24 * 60);
			if (days > 0) {
				format = "%1$,d天%2$,d小时%3$,d分钟";
				array = new Object[] { days, hours, minutes };
			} else if (hours > 0) {
				format = "%1$,d小时%2$,d分钟";
				array = new Object[] { hours, minutes };
			} else {
				format = "%1$,d分钟";
				array = new Object[] { minutes };
			}
			html = String.format(format, array);
		}
		return html;
	}
	
	/**
	 * 传入天、小时、秒转换成秒
	 * @param day
	 * @param hour
	 * @param min
	 * @return
	 */
	public static int dayHourMinConverMin(int day, int hour, int min) {
		int days = day * 24 * 60;
		int hours = hour * 60;
		return days + hours + min;
	}
		
	 /**
	  * 比较时间大小
	  * @param d1
	  * @param d2
	  * @return
	  */
	 public static Boolean sameDate(Date d1, Date d2, String dateFormat){
		  SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
		  String format1 = fmt.format(d1);
		  String format2 = fmt.format(d2);
		  return format1.equals(format2);
	  }
		public static Date getStartDate(Date date) {
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.set(Calendar.HOUR_OF_DAY, 0);
		    calendar.set(Calendar.MINUTE, 0);
		    calendar.set(Calendar.SECOND, 0);
		    calendar.set(Calendar.MILLISECOND, 0);
		    return calendar.getTime();
		}
		public static Date getEndDate(Date date) {
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.set(Calendar.HOUR_OF_DAY, 23);
		    calendar.set(Calendar.MINUTE, 59);
		    calendar.set(Calendar.SECOND, 59);
		    calendar.set(Calendar.MILLISECOND, 59);
		    return calendar.getTime();
		}
}
