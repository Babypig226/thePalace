package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdorderDTO {
	Integer orderNo;
	Timestamp orderDate;
	Integer gcompanyNo;
	String goodsNo;

}
