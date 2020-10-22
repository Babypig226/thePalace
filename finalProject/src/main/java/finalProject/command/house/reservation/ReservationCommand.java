package finalProject.command.house.reservation;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCommand {
	String roomNo;
	String userId;
	String rsContent;
	String rsPh;
	Date usingDate;
}
