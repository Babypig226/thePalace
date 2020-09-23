package finalProject.service.dep;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.DepCommand;
import finalProject.domain.DepDTO;
import finalProject.mapper.DepMapper;

@Component
@Service
public class DepService {
	@Autowired
	DepMapper depMapper;
	
	public void depInsert(DepCommand depCommand, HttpSession session) {
		DepDTO dto = new DepDTO();
		dto.setDepartmentName(depCommand.getDepartmentName());
		dto.setDepartmentPh(depCommand.getDepartmentPh());
		String departmentAddr = "";
		for (int i = 0; i < depCommand.getDepartmentAddr().length; i++) {
			departmentAddr += depCommand.getDepartmentAddr()[i]+"`";
		}
		dto.setDepartmentAddr(departmentAddr);
		depMapper.depInsert(dto);
	}
	

}
