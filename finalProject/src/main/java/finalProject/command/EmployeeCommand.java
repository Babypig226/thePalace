package finalProject.command;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeCommand {
	String employeeNo;
	String departmentName;
	String employeeId;
	String employeeName;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	LocalDateTime employeeBirth;
	String employeePh;
	String employeeEmail;
	String[] employeeAddr;
	String employeeType;
	Integer employeeSal;
	String[] employeeAccount;
	MultipartFile identityCard;
	MultipartFile copyBankbook;
	MultipartFile employeeContract;
	MultipartFile academicAbility;
	MultipartFile careerCertificate;

}
