package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TchContractDTO {
	String tcontractNo;
	String tcontractTerm;
	String tcontractType;
	Integer teacherSal;
	String teacherAccount;
	String checkSafe;
	String tcopyBankbook;
	String tidentitiCard;
	String empNo;
	String teacherNo;

}
