package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IpgoDTO {
	Integer ipgoNo; 
	Integer shopNo;
	String goodsNo;
	Integer ipgoQty;
	Timestamp checkDate;
	String checkOk;
	Timestamp ipgoDate;
	
}
