package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	String employeeNo;
	String employeeId;
	String employeePw;
	String employeeName;
	String employeeAddr;
	Timestamp employeeBirth;
	String employeeAccount;
	String employeeContract;
	Integer employeeSal;
	String employeeType;
	String identityCard;
	String academicAbility;
	String careerCertificate;
	String copyBankbook;
	String departmentNo;
	String employeePh;
	String employeeEmail;


}
