package finalProject.service.admin.emp;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.EmployeeCommand;
import finalProject.domain.EmployeeDTO;
import finalProject.mapper.EmployeeMapper;
import finalProject.service.addr.AddressService;
import finalProject.service.dateFormat.DateFormatService;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class EmployeeRegistService {
	@Autowired
	AddressService addressService;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	DateFormatService dateFormatService;
	@Autowired
	EmployeeMapper employeeMapper;
	
	public void registEmp(EmployeeCommand employeeCommand, HttpServletRequest request) {
		EmployeeDTO dto = new EmployeeDTO();
		//인적사항
		dto.setDepartmentNo(employeeCommand.getDepartmentNo());
		dto.setEmployeeId(employeeCommand.getEmployeeId());
		dto.setEmployeePw(employeeCommand.getEmployeePw());
		dto.setEmployeeName(employeeCommand.getEmployeeName());
		dto.setEmployeeAddr(addressService.updateAddress(employeeCommand.getEmployeeAddr()));
		dto.setEmployeeBirth(dateFormatService.dateToTimestamp(employeeCommand.getEmployeeBirth()));
		dto.setEmployeePh(employeeCommand.getEmployeePh());
		dto.setEmployeeEmail(employeeCommand.getEmployeeEmail());
		//고용정보
		dto.setEmployeeAccount(employeeCommand.getEmployeeAccount());
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
