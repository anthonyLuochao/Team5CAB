package utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class CABDate {
	public static Date getToday() {
		Calendar today = Calendar.getInstance();
		today.clear(Calendar.HOUR); 
		today.clear(Calendar.MINUTE); 
		today.clear(Calendar.SECOND);
		return today.getTime();
	}
	
	public static LocalDate getLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

	}
	
	public static Date plusDays(Date date, int numberOfDays) {
		return java.sql.Date.valueOf(getLocalDate(date).plusDays(numberOfDays));
	}
}
