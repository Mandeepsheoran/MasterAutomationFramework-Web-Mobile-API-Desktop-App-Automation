/**
 * 
 */
package org.igt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Feb 7, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see SimpleDateFormat
 */
public class DateFormatUtils {
	
	private static String pattern = "yyyy-MM-dd'T'HH:mm:ss-SSSSZ";
	private static final String NEWYORKDATETIME = "America/New_York";  
	/**
	 * Method to provide date format in yyyy-MM-dd format
	 * Feb 7, 2023
	 * @author Mandeep Sheoran
	 * @see SimpleDateFormat
	 */
	public static String yyyyMmDdFormat() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern);		
		return smpldtfrmt.format(new Date());
	}
	/**
	 * Method to provide date format in "yyyy-MM-dd'T'HH:mm:ss-SSSSZ" format for New York(America) zone.
	 * Feb 7, 2023
	 * @author Mandeep Sheoran
	 */
	public static String regionalCurrentDateTimeFormat() {	
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern, Locale.US);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone(NEWYORKDATETIME));
		String date = smpldtfrmt.format(new Date());
		return date.substring(0, 24);
	}
	/**
	 * Method to provide date format in "yyyy-MM-dd'T'HH:mm:ss-SSSSZ" format for UTC time zone.
	 * Feb 7, 2023
	 * @author Mandeep Sheoran
	 */
	public static String currentUTCDateTimeFormat() {	
		SimpleDateFormat smpldtfrmt = new SimpleDateFormat(pattern, Locale.US);
		smpldtfrmt.setTimeZone(TimeZone.getTimeZone("UTC"));
		String date = smpldtfrmt.format(new Date());
		return date.substring(0, 24);
	}
}