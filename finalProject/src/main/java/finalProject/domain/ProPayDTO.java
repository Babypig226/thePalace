package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProPayDTO {
	String payNo;
	Timestamp payDate;
	String payOption;
	Integer totalPay;
	String couponNo;
}
