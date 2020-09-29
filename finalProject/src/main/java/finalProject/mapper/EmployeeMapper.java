package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.EmployeeDTO;
import finalProject.domain.StartEndPageDTO;

@Component
@Repository("finalProject.mapper.EmployeeMapper")
public interface EmployeeMapper {
	public void  registEmployee(EmployeeDTO dto);
	public List<EmployeeDTO> getEmpList(StartEndPageDTO dto);
	public void deleteEmployee(String employeeNo);
	public void updateEmp(EmployeeDTO dto);

}
