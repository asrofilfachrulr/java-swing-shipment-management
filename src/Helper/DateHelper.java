package Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	public static String dateToFormattedString(Date date) {
		if (date == null)
			return "-";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		return sdf.format(date);
	}

	public static String parseDateToHHmm(Date date) {
		if (date == null)
			return "-";
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(date);
	}

	// Method to parse Date to DD:MM:YYYY format
	public static String parseDateToDDMMYYYY(Date date) {
		if (date == null)
			return "-";
		SimpleDateFormat formatter = new SimpleDateFormat("dd:MM:yyyy");
		return formatter.format(date);
	}

	public static Date parseStringToDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd:MM:yyyy");
            return formatter.parse(dateString);
	}
        
}
