package finalProject.service.admin.teacherContract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.EmployeeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TchContractDTO;
import finalProject.mapper.EmployeeMapper;
import finalProject.mapper.TeacherContractMapper;

@Component
@Service
public class TchContractListService {
	@Autowired
	TeacherContractMapper teacherContractMapper;
	@Autowired
	EmployeeMapper employeeMapper;

	public void getTctrtLists(String teacherNo, Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, teacherNo);
		List<TchContractDTO> lists = teacherContractMapper.getTcontractsList(dto);
		EmployeeDTO edto = new EmployeeDTO();
		for (int i = 0; i < lists.size(); i++) {
			dto.setNum(lists.get(i).getEmpNo());
			edto = employeeMapper.getEmpList(dto).get(0);
			lists.get(i).setEmpNo(edto.getEmployeeName());
		}
		model.addAttribute("tclist", lists);
		
	}
	

}
