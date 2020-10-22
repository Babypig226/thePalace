package finalProject.domain.house;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
	String roomNo;
	String reservationNo;
	Timestamp reservationDate;
	Integer reservationCount;
	String userId;
	String rsContent;
	String rsPh;
	Timestamp usingDate;
	
	
}
