package com.cand.jspfunc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JspFunction {
	
	  private JspFunction() {}

	     public static String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
	         return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
	     }
	     
	     public static String validBigDecimal(String text){
	    	    try {
	    	        new BigDecimal(text);
	    	        return text;
	    	    } catch (NumberFormatException e) {
	    	        return "";
	    	    }
	     }
}
