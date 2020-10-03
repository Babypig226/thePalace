package finalProject.service.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PgbasketDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramBasketMapper;
import finalProject.mapper.ProgramMapper;

@Component
@Service
public class ProgramCartService {
	@Autowired
	ProgramMapper programMapper;	
	@Autowired
	ProgramBasketMapper programBasketMapper;

	public void programCartAdd(String programNo) throws Exception{
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, "1111" , programNo);		
		programBasketMapper.cartInsert(startEndPageDTO);	
	}

	public void programCartList(Model model) throws Exception {
		//StartEndPageDTO startEndPageDTO = new StartEndPageDTO();
		List<PgbasketDTO> list = programBasketMapper.pgbasketlist();
		int i = 0;
		for(i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			model.addAttribute("prglist", list.get(i).getPro());
		}

		model.addAttribute("pgclist", list);
	}

}
