package finalProject.service.admin.etraining;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.EtrainingDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.EtrainingMapper;

@Component
@Service
public class EtrainingListService {
	@Autowired
	EtrainingMapper etrainingMapper;

	public void getEtrainingList(Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, null);
		List<EtrainingDTO> lists = etrainingMapper.getEtrainingList(dto);
		for (int i = 0; i < lists.size(); i++) {
			if(lists.get(i).getNecessity().equals("O")) {
				lists.get(i).setNecessity("필수");
			}else {
				lists.get(i).setNecessity("선택");
				
			}
		}
		model.addAttribute("list", lists);
		
	}
	
	

}
