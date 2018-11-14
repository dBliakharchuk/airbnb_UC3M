package logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtils {
	public static List<Date> getDatesBetween(Date startDate, Date endDate) {
		if (startDate.after(endDate)) {
			Date temp = endDate;
			endDate = startDate;
			startDate = temp;
		}
	    List<Date> datesInRange = new ArrayList<>();
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(startDate);
	     
	    Calendar endCalendar = new GregorianCalendar();
	    endCalendar.setTime(endDate);
	 
	    while (calendar.before(endCalendar)) {
	        Date result = calendar.getTime();
	        datesInRange.add(result);
	        calendar.add(Calendar.DATE, 1);
	    }
	    return datesInRange;
	}
	
}
