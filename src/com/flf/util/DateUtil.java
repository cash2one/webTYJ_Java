package com.flf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	 /**   
	 * 得到本月的最后一天   
	 *    
	 * @return   
	 */    
	public String getMonthLastDay(String month) {
		String[] str=month.split("-");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR,Integer.parseInt(str[0]));
		c.set(Calendar.MONTH, Integer.parseInt(str[1])-1);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return dateFormat.format(c.getTime());
	}
	
	/**
	 * 查询当前时间，返回时间类型 
	 * 
	 * @return
	 */
	public static Date currentDate() {
		long dateLong = System.currentTimeMillis();
		Date date = new Date(dateLong);
		return date;
	}
	
	public static String getToday(){
	    String time = "";
	    time = getToday("yyyy-MM-dd");
	    return time;
	}
	  
	public static String getToday(String format){
	    return getDateStr(Calendar.getInstance().getTime(), format);
	}
	   
	public static String getDateStr(Date date, String format){
	    SimpleDateFormat df = new SimpleDateFormat(format);
	    return df.format(date);
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
	}
}
