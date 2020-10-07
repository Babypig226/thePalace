package finalProject.service.hr.empInterview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.EmpInterviewCommand;
import finalProject.domain.EmpInterviewDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.EmpInterviewMapper;
import finalProject.mapper.EnoticeMapper;

@Component
@Service
public class EmpInterviewRegistService {
	@Autowired
	EnoticeMapper enoticeMapper;
	@Autowired
	EmpInterviewMapper empInterviewMapper;

	public void registScore(String acceptNo, EmpInterviewCommand empInterviewCommand) {
		EmpInterviewDTO dto = new EmpInterviewDTO();
		dto.setAcceptNo(acceptNo);
		dto.setExamGuide(empInterviewCommand.getExamGuide());
		dto.setInterviewScore(empInterviewCommand.getInterviewScore());
		dto.setPaperScore(empInterviewCommand.getPaperScore());
		String[] num = acceptNo.split("-");
		StartEndPageDTO sdto = new StartEndPageDTO(1L, 1L, null, num[0]);
		dto.setDepartmentNo(enoticeMapper.getEnoticeList(sdto).get(0).getDepartmentNo());
		Integer totScore = empInterviewCommand.getInterviewScore()+empInterviewCommand.getPaperScore();
		dto.setTotScore(totScore);
		empInterviewMapper.insertScore(dto);
		
	}
	

}
