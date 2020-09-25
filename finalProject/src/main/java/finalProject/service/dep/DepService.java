package finalProject.service.dep;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.DepCommand;
import finalProject.domain.DepDTO;
import finalProject.mapper.DepMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class DepService {
	@Autowired
	DepMapper depMapper;
	@Autowired
	AddressService addressService;
	public void depInsert(DepCommand depCommand, HttpSession session) {
		String departmentAddr = addressService.updateAddress(depCommand.getDepartmentAddr());
		DepDTO dto = new DepDTO("", depCommand.getDepartmentName(), depCommand.getDepartmentPh(), departmentAddr);
		depMapper.depInsert(dto);
	}
	

}
