package finalProject.service.admin.etraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.EtrainingDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.EtrainingMapper;

@Component
@Service
public class EtrainingDetailService {
	@Autowired
	EtrainingMapper etrainingMapper;

	public void getEtrainingDetail(Model model, String trainingNo) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, trainingNo);
		EtrainingDTO edto = etrainingMapper.getEtrainingList(dto).get(0);
		if(edto.getNecessity().equals("O")) {
			edto.setNecessity("필수");
		}else {
			edto.setNecessity("선택");
		}
		model.addAttribute("list", edto);
		
	}
	

}
