package finalProject.command;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpgoCommand {
	Integer ipgoNo; 
	Integer shopNo;
	String goodsNo;
	Integer ipgoQty;
	Date checkDate;
	String checkOk;
}
		
		
