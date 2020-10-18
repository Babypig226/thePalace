package finalProject.service.hr.teacherInterview;

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
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		StartEndPageDTO sdto = new StartEndPageDTO(1L, 1L, authInfo.getId(), null);
		EmployeeDTO edto = employeeMapper.getEmpList(sdto).get(0);
		sdto.setUserId(regNo);
		sdto.setNum(edto.getEmployeeNo());
		TinterviewDTO tdto = tinterviewMapper.getTinterviewList(sdto).get(0);
		
		if(tdto != null) {
			if(tdto.getTinterviewScore() <= 0 || tdto.getTinterviewScore() == null) {
				model.addAttribute("list", tdto);
				return "thymeleaf/hr/teacher-interview/teacher-interview-moidfy";
			}else {
				model.addAttribute("list", tdto);
				return "thymeleaf/hr/teacher-interview/teacher-interview-detail";
			}
		}else {
			model.addAttribute("regNo", regNo);
			return "thymeleaf/hr/teacher-interview/teacher-interview-write";
		}
		
		
		
		
	}
	

}
