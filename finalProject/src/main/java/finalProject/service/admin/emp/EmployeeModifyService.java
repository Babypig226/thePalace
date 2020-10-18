package finalProject.service.admin.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.EmployeeCommand;
import finalProject.domain.EmployeeDTO;
import finalProject.mapper.EmployeeMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class EmployeeModifyService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	AddressService addressService;
	public void empModify(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeNo(employeeCommand.getEmployeeNo());
		dto.setEmployeePh(employeeCommand.getEmployeePh());
		dto.setEmployeeEmail(employeeCommand.getEmployeeEmail());
		dto.setEmployeeAddr(addressService.updateAddress(employeeCommand.getEmployeeAddr()));
		dto.setEmployeeSal(employeeCommand.getEmployeeSal());
		dto.setEmployeeAccount(employeeCommand.getEmployeeAccount());
		employeeMapper.updateEmp(dto);
	}

}
