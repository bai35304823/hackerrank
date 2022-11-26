package hackerrank;

import java.time.LocalDate;

public class java_date_and_time {
	/*
	 * Sample Input
	 * 
	 * 08 05 2015 
	 * Sample Output
	 * 
	 * WEDNESDAY
	 */
	
	public static String findDay(int month, int day, int year) {
	    LocalDate dayy = LocalDate.of(year, month, day);
	    return dayy.getDayOfWeek().name();
	    }
}
