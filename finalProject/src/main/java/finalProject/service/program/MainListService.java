package finalProject.service.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramMapper;

@Component
@Service
public class MainListService {
	@Autowired
	ProgramMapper programMapper;

	public void mainlist(Model model) throws Exception{		
		List<ProgramDTO> list = programMapper.mainlist();
		
		model.addAttribute("list", list);
	}

}
