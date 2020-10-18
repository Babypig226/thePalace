package finalProject.service.hr.teacherInterview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.TinterviewCommand;
import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TinterviewDTO;
import finalProject.mapper.TinterviewMapper;

@Component
@Service
public class TinterviewUpdateService {
	@Autowired
	TinterviewMapper tinterviewMapper;
	public void updateTinterview(TinterviewCommand tinterviewCommand) {
		StartEndPageDTO sdto = new StartEndPageDTO(1L, 1L, tinterviewCommand.getRegNo(), tinterviewCommand.getEmpNo());
		
		TinterviewDTO dto = tinterviewMapper.getTinterviewList(sdto).get(0);
		dto.setProGuide(tinterviewCommand.getProGuide());
		dto.setTinterviewScore(tinterviewCommand.getTinterviewScore());
		dto.setTeacherTotalScore(dto.getTinterviewScore()+dto.getTdocScore());
		tinterviewMapper.updateTinterview(dto);
		
	}
	

}
