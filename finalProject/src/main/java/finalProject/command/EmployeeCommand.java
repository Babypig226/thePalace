package finalProject.command;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeCommand {
	String employeeNo;
	String departmentNo;
	@NotEmpty(message = "ID를 입력하세요")
	String employeeId;
	@NotEmpty(message = "직원명를 입력하세요")
	String employeeName;
	Date employeeBirth;
	@NotEmpty(message = "연락처를 입력하세요")
	String employeePh;
	@NotEmpty(message = "E-mail을 입력하세요")
	String employeeEmail;
	String[] employeeAddr;
	@NotEmpty(message = "고용형태를 선택하세요")
	String employeeType;
	@NotEmpty(message = "급여를 입력하세요")
	Integer employeeSal;
	@NotEmpty(message = "계좌정보를 입력하세요")
	String employeeAccount;
	@NotEmpty(message = "신분증사본을 등록하세요")
	MultipartFile identityCard;
	@NotEmpty(message = "통장사본을 등록하세요")
	MultipartFile copyBankbook;
	@NotEmpty(message = "고용계약서를 등록하세요")
	MultipartFile employeeContract;
	@NotEmpty(message = "학력증빙자료를 등록하세요")
	MultipartFile academicAbility;
	@NotEmpty(message = "경력증빙자료를 등록하세요")
	MultipartFile careerCertificate;

}
