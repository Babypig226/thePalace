package finalProject.service.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramMapper;

@Component
@Service
public class ProgramDetailService {
	@Autowired
	ProgramMapper programMapper;

	public void programDetail(String programName, Model model) throws Exception{
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, programName);
		
		ProgramDTO prodto = programMapper.getProgramList(startEndPageDTO).get(0);
		model.addAttribute("prodto", prodto);	
	}

}
