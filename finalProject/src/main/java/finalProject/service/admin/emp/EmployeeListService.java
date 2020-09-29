package finalProject.service.admin.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.EmployeeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.EmployeeMapper;

@Component
@Service
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;
	public void getEmpList(Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, null);
		List<EmployeeDTO> lists = employeeMapper.getEmpList(dto);
		model.addAttribute("list", lists);
		
	}
	

}
