package finalProject.service.admin.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.AddressDTO;
import finalProject.domain.EmployeeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.DepMapper;
import finalProject.mapper.EmployeeMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class EmployeeDetailService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	DepMapper depMapper;
	@Autowired
	AddressService addressService;
	public void empDetail(String employeeNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, employeeNo);
		EmployeeDTO list = employeeMapper.getEmpList(dto).get(0);
		AddressDTO addr = addressService.devideAddress(list.getEmployeeAddr());
		list.setEmployeeAddr(addressService.rebuildAddress(list.getEmployeeAddr()));
		dto.setNum(list.getDepartmentNo());
		model.addAttribute("departmentName", depMapper.getDepList(dto).get(0).getDepartmentName());
		model.addAttribute("list", list);
		model.addAttribute("addr", addr);
		
		
	}
	

}
