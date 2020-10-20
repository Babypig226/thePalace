package finalProject.command;



import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeCommand {
	String employeeNo;
	String departmentNo;
	String employeeId;
	String employeePw;
	String employeeName;
	String employeeBirth;
	String employeePh;
	String employeeEmail;
	String[] employeeAddr;
	String employeeType;
	Integer employeeSal;
	String employeeAccount;
	MultipartFile identityCard;
	MultipartFile copyBankbook;
	MultipartFile employeeContract;
	MultipartFile academicAbility;
	MultipartFile careerCertificate;

}
