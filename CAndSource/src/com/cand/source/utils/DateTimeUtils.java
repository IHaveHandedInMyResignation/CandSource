package com.cand.source.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
	
	
	public static LocalDateTime convertToLocalDateTime(String date) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       return LocalDateTime.parse(date, formatter); 
     }
	
	public static boolean validatePersonalTaskDateTimes(LocalDateTime reminderTime, LocalDateTime startTime, LocalDateTime finishTime){
		
		boolean isValid = true;
		if(startTime != null){
			if(reminderTime != null)
				isValid &=	reminderTime.isBefore(startTime);
			if(finishTime != null)
				isValid &= startTime.isBefore(finishTime);
			return isValid;
		}
		return false;
	}

}
