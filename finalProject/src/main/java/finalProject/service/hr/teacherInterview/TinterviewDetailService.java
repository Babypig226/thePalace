package finalProject.service.hr.teacherInterview;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.AuthInfo;
import finalProject.domain.EmployeeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TinterviewDTO;
import finalProject.mapper.EmployeeMapper;
import finalProject.mapper.TinterviewMapper;

@Component
@Service
public class TinterviewDetailService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	TinterviewMapper tinterviewMapper;
	public String getTinterviewDetail(String regNo, Model model, HttpSession session) {
		//AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		StartEndPageDTO sdto = new StartEndPageDTO(1L, 1L, null, regNo);
		//EmployeeDTO edto = employeeMapper.getEmpList(sdto).get(0);
		List<TinterviewDTO> tdto = tinterviewMapper.getTinterviewList(sdto);
		
		if(tdto.size() > 0) {
			if(tdto.get(0).getTinterviewScore() == 0 || tdto.get(0).getTinterviewScore() == null) {
				model.addAttribute("list", tdto.get(0));
				return "thymeleaf/hr/teacher-interview/teacher-interview-moidfy";
			}else {
				model.addAttribute("list", tdto.get(0));
				return "thymeleaf/hr/teacher-interview/teacher-interview-detail";
			}
		}else {
			model.addAttribute("regNo", regNo);
			return "thymeleaf/hr/teacher-interview/teacher-interview-write";
		}
		
		
		
		
	}
	

}
