package Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	public static String dateToFormattedString(Date date) {
		if(date == null) return "-";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        return sdf.format(date);
	}
}
