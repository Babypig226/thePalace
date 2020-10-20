package finalProject.service.dateFormat;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class DateFormatService {
	public Timestamp dateToTimestamp(Date date) {
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		String modifiedDate = fmt.format(date); 
		Timestamp storeDate = Timestamp.valueOf(modifiedDate);
		return storeDate;
	}
	public Timestamp dateToTimestamp(String date) {
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		Timestamp storeDate = Timestamp.valueOf(date);
		return storeDate;
	}
	

}
