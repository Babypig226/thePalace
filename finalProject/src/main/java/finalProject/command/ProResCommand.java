package finalProject.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProResCommand {
	String rsPh;
	Date usingDate;
	//Timestamp usingDate;
	String rsContent;
	Integer reservationCount;
}
