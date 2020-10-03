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
public class ProgramListService {
	@Autowired
	ProgramMapper programMapper;

	public void programList(Model model, Integer page) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		StartEndPageDTO startEndPageDTO = 
				new StartEndPageDTO(startRow, endRow, null, null);

		List<ProgramDTO> prolists = programMapper.getProgramList(startEndPageDTO);
		
		model.addAttribute("prolists", prolists);
		
		
	}

}
