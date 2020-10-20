package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProResDTO {
	String reservationNo;
	Timestamp reservationDate;
	Integer reservationCount;
	String rsContent;
	String rsPh;
	String userId;
	Timestamp usingDate;
}
