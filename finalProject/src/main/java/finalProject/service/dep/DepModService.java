package finalProject.service.dep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.DepCommand;
import finalProject.domain.DepDTO;
import finalProject.mapper.DepMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class DepModService {
	
	@Autowired
	DepMapper depMapper;
	@Autowired
	AddressService addressService;
	public void depModify(DepCommand depCommand) {
		String departmentAddr = addressService.updateAddress(depCommand.getDepartmentAddr());
		DepDTO dto = new DepDTO(depCommand.getDepartmentNo(), depCommand.getDepartmentName(), depCommand.getDepartmentPh(), departmentAddr);
		depMapper.depModify(dto);
	}
	

}
