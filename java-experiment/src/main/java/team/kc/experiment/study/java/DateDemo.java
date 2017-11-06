package team.kc.experiment.study.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	public static final String YYYYMMDD = "yyyyMMdd";
	
	public static final SimpleDateFormat format = new SimpleDateFormat(YYYYMMDD);

	public static void formatTest () {
		SimpleDateFormat format = new SimpleDateFormat(YYYYMMDD);
		
		String todayStr = format.format( new Date() );
		try {
			Date date = format.parse( "20170101" );
			date.getTime();
		} catch (ParseException e) { }
		
		System.out.println( todayStr );
	}
	
	public static void modifyTest () {
		Calendar cal = Calendar.getInstance();
		cal.add( Calendar.DAY_OF_MONTH, 40);//往后40天
		cal.add( Calendar.MONTH, -1);//向前1个月
		System.out.println( cal.getTime() );
		
	}
	
	public static void main (String[] args) {
		formatTest();
		modifyTest();
	}
	
}
