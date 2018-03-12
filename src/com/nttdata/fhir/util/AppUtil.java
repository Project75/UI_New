package com.nttdata.fhir.util;

import java.util.Calendar;
import java.util.Date;

public class AppUtil {
	
	public static Date futureEndDate() {
		Date retVal = null;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 9998);
		calendar.set(Calendar.MONTH, 12);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		calendar.set(Calendar.HOUR, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);  // 999 did not work in query (i.e., returned next day at 00:00:000)
		
		retVal = calendar.getTime();
		
		return retVal;	
	}
	
	public static Date previousDay() {
		return relativeDay(-1);
	}
	
	public static Date relativeDay(int numberOfDaysToAdd) {
		Date retVal = null;

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDaysToAdd);
		retVal = calendar.getTime();
		return retVal;
	}

	public static Date getCurrentDate() {
		Date retVal = null;

		Calendar calendar = Calendar.getInstance();
		retVal = calendar.getTime();
		return retVal;
	}


}
