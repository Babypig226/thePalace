package finalProject.service.hr.teacherInterview;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.AuthInfo;
import finalProject.command.TinterviewCommand;
import finalProject.domain.EmployeeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TinterviewDTO;
import finalProject.mapper.EmployeeMapper;
import finalProject.mapper.TinterviewMapper;

@Component
@Service
public class TinterviewRegistService {
	@Autowired
	TinterviewMapper tinterviewMapper;
	@Autowired
	EmployeeMapper	employeeMapper;
	public void insertTinterview(TinterviewCommand tinterviewCommand, HttpSession session) {
		TinterviewDTO dto = new TinterviewDTO();
		dto.setRegNo(tinterviewCommand.getRegNo());
		dto.setTinterviewScore(tinterviewCommand.getTinterviewScore());
		dto.setTdocScore(tinterviewCommand.getTdocScore());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		StartEndPageDTO sdto = new StartEndPageDTO(1L, 1L, authInfo.getId(), null);
		EmployeeDTO edto = employeeMapper.getEmpList(sdto).get(0);
		dto.setEmpNo(edto.getEmployeeNo());
		Integer teacherTotalScore = tinterviewCommand.getTdocScore()+tinterviewCommand.getTinterviewScore();
		dto.setTeacherTotalScore(teacherTotalScore);
		dto.setProGuide(tinterviewCommand.getProGuide());
		tinterviewMapper.insertTinterview(dto);
	}

}
