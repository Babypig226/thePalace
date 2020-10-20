package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartListDTO {
	String programNo;
	Integer amount;
	String checkOp;
	String programName;
}
