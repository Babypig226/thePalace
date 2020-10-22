package finalProject.domain.house;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixturesDTO {
	
	String equipNo;
	String roomNo;
	String equipName;
	Integer equipQty;
	Timestamp eOrderDate;
	Integer eOrderQry;
}
