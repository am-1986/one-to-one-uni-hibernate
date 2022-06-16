package com.luv2code.hibernate.demo.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	
	// read a date string and parse/convert to a date
	public static Date parseDate(String date) throws ParseException{
		
		Date theDate = formatter.parse(date);
		
		return theDate;
		
	}
	
	// read a date and convert to string
	public static String formatDate(Date theDate) {
		
		String result = null;
		
		if (theDate != null) {
			
			result = formatter.format(theDate);
		}
		
		return result;
	}
}
