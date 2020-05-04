package Calendar_Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class Calnedar_Test_1 {

	public static void main(String[] args) {
		 
		LocalDate date1=  LocalDate.parse("2020-01-02",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate date2=  LocalDate.parse("2020-01-04",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		/*int diff = date1.compareTo(date2);
		
		Period p = Period.between(date1, date2);
		p.getMonths();*/
		
		LocalDateTime local_time = LocalDateTime.now();
		System.out.println("LocalDateTime " + local_time);
		//LocalDateTime local_time_parsed = LocalDateTime.parse("2015-10-23T03:34:40", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.US));
		//String local_time_formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(local_time_parsed);
		
		
		LocalDateTime local_time_parsed = LocalDateTime.parse(local_time.toString().replace("T", " "),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")); // prefer this until otherwise required.
		//LocalDateTime local_time_parsed_1 = LocalDateTime.parse(local_time.toString(),DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS",Locale.US)); // Same as before way 2 
		System.out.println("local_time_formatted >> " + local_time_parsed);
		
		
		LocalDate local_date =  LocalDate.now();
		System.out.println("local_date " + local_date);
		
		//handleMultipleDateFormat("1800-04-11 10:10:10");
		
		compareDates("2016-11-11" ,"2020-01-04");
		
	}
	
	//NOTE :: assume they are in yyyy-MM-dd format , else apply the handleMultipleDateFormat logic to try catch and parse the unknown format.
	public static void getNumberofWeekends(String str1, String str2) {
		LocalDate date1 = LocalDate.parse(str1, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US));
		LocalDate date2 = LocalDate.parse(str2, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US));
		
		int num_of_weekends =0;
		while(date1.isBefore(date2)) {
			if(date1.getDayOfWeek().getValue() == Calendar.SUNDAY || date1.getDayOfWeek().getValue() == Calendar.SATURDAY) {
				num_of_weekends +=1;
			}
			date1.plusDays(1);
		}
		
		System.out.println("num_of_weekends " + num_of_weekends);
	}
	
	// comapre 2 dates 
	
	public static void compareDates(String str1, String str2) {
		LocalDate date1 = LocalDate.parse(str1, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US));
		LocalDate date2 = LocalDate.parse(str2, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US));
		
		System.out.println(" compareDates " + date1 + " and  " + date2 );
		
		int diff = date1.compareTo(date2);
		System.out.println("diff " + diff); // 0 , -1 , 1
		
		Period p = Period.between(date1, date2);
		System.out.println("p.getMonths() " + p.getMonths()); // just gives diff. in months max 11 months 
		System.out.println("p.getYears() " + p.getYears());
		
		
		// get total months diff including year 
		
		int total_months_diff =0;
		if(p.getYears() > 1) {
			total_months_diff =  (p.getYears() * 12) + p.getMonths();
		}
		System.out.println("total_months_diff " + total_months_diff); 
	}
	
	
	public static void checKLeapYear(LocalDate localDate ) {
		//localDate.isLeapYear();
		int year = localDate.getYear();
		boolean isLeap = false;
		if(year %4 == 0) {
			
			if(year % 100 ==0) {
				if(year%400 ==0 ) {
					isLeap = true;
				}
				else {
					isLeap = false;
				}
			}
			else {
				isLeap=true;
			}
		}
		else
			isLeap=false;
		
		System.out.println("year check " + year + " is " + isLeap);
	}
	
	public static void handleMultipleDateFormat(String dateString) {
		System.out.println("input date " + dateString);
		LocalDate localDate = null;
		try {
			localDate = LocalDate.parse(dateString,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		catch(Exception e) {
			try {
				localDate = LocalDate.parse(dateString,DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
				
			}
			catch(Exception e1) {
				System.out.println("unknown format of date string provided...");
			}
		}
		//System.out.println(date);
		checKLeapYear(localDate);
	}
	
}
