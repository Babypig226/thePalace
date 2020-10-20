package finalProject.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PgbasketDTO {
	String programNo;
	String userId;
	Integer amount;
	String checkOp;
	
	//PgbasketDTO cart;
	List<ProgramDTO> pro;
}
