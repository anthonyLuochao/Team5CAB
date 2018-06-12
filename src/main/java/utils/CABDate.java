package utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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
	
	public static LocalDateTime getLocalDateTime(Date date) {
		Instant i = date.toInstant();
		return LocalDateTime.ofInstant(i,ZoneId.systemDefault());
	}
	
	public static Date plusDays(Date date, int numberOfDays) {
		return Date.from((getLocalDateTime(date).plusDays(numberOfDays)).toInstant(OffsetDateTime.now().getOffset()));
	}
}
