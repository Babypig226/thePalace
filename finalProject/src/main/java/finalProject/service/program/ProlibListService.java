package finalProject.service.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.ProgramLibDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramLibMapper;

@Component
@Service
public class ProlibListService {
	@Autowired
	ProgramLibMapper programLibMapper;

	public void prolibList(Model model, Integer page) throws Exception{		
		int nowPage = 1;
		if(page != null) {
			nowPage = page;
		}
		int limit = 10; 
		int limitPage = 10 ;
		Long startRow = ((long)nowPage -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		StartEndPageDTO startEndPageDTO = 
				new StartEndPageDTO(startRow, endRow, null, null);
		
		List<ProgramLibDTO> pliblist = programLibMapper.getproLibList(startEndPageDTO);
		System.out.println("pliblist : "+pliblist);
		model.addAttribute("pliblist", pliblist);
	}

}
