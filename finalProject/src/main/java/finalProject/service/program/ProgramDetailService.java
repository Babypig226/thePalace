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

	public void programDetail(String programNo, Model model) throws Exception{
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, "1111", programNo);
		
		ProgramDTO prodto = programMapper.getProgramList(startEndPageDTO).get(0);
		System.out.println(prodto.getProgramNo());
		model.addAttribute("prodto", prodto);	
	}

}
