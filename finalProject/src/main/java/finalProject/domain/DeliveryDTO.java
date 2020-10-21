package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO {
	
	String deliveryNo;
	Timestamp deliveryDate;
	String deliveryAddr;
	String receiverName;
	String deliveryNote;
	String buyNo;
	String payNo;
	

}
