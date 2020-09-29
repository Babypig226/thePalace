package finalProject.service.admin.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.mapper.EmployeeMapper;

@Component
@Service
public class EmployeeDeleteService {
	@Autowired
	EmployeeMapper employeeMapper;

	public void deleteEmployee(String employeeNo) {
		employeeMapper.deleteEmployee(employeeNo);
		
	}
}
