/**
 * 
 */
package com.cognizant.MovieCruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author VishnuKumar
 *
 */
public class DateUtil {
	public static Date convertToDate(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d = df.parse(date);
		return d;

	}

}
