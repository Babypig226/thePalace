package finalProject.service.admin.emp;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import finalProject.command.EmployeeCommand;
import finalProject.domain.EmployeeDTO;
import finalProject.mapper.EmployeeMapper;
import finalProject.service.addr.AddressService;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class EmployeeRegistService {
	@Autowired
	AddressService addressService;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	EmployeeMapper employeeMapper;
	
	public void registEmp(EmployeeCommand employeeCommand, HttpServletRequest request) {
		MultipartFile mf = employeeCommand.getCopyBankbook();
		System.out.println("regist emp file"+mf.getOriginalFilename());
		EmployeeDTO dto = new EmployeeDTO();
		//인적사항
		dto.setDepartmentNo("2");
		dto.setEmployeeId(employeeCommand.getEmployeeId());
		dto.setEmployeePw("PW");
		dto.setEmployeeName(employeeCommand.getEmployeeName());
		String addr = addressService.updateAddress(employeeCommand.getEmployeeAddr());
		dto.setEmployeeAddr(addr);
		Timestamp employeeBirth = Timestamp.valueOf(employeeCommand.getEmployeeBirth());
		dto.setEmployeeBirth(employeeBirth);
		dto.setEmployeePh(employeeCommand.getEmployeePh());
		dto.setEmployeeEmail(employeeCommand.getEmployeeEmail());
		//고용정보
		String employeeAccount = "";
		for (String string : employeeCommand.getEmployeeAccount()) {
			employeeAccount += string + "`";
		} 
		dto.setEmployeeAccount(employeeAccount);
		dto.setEmployeeType(employeeCommand.getEmployeeType());
		dto.setEmployeeSal(employeeCommand.getEmployeeSal());
		//증빙자료업로드
		String path = "/static/employee/upload";
		String filePath = request.getServletContext().getRealPath(path);
		dto.setCopyBankbook(fileUploadService.fileUpload(employeeCommand.getCopyBankbook(), filePath));
		dto.setAcademicAbility(fileUploadService.fileUpload(employeeCommand.getAcademicAbility(), filePath));
		dto.setCareerCertificate(fileUploadService.fileUpload(employeeCommand.getCareerCertificate(), filePath));
		dto.setIdentityCard(fileUploadService.fileUpload(employeeCommand.getIdentityCard(), filePath));
		dto.setEmployeeContract(fileUploadService.fileUpload(employeeCommand.getEmployeeContract(), filePath));
		employeeMapper.registEmployee(dto);
		
		
	}

}
