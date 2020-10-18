package finalProject.service.rent.rentScore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.RentScoreCommand;
import finalProject.domain.RentScoreDTO;
import finalProject.mapper.RentScoreMapper;

@Component
@Service
public class RentScoreInsertService {
	@Autowired
	RentScoreMapper rentScoreMapper;
	public void insertRentScore(RentScoreCommand rentScoreCommand, Model model) {
		RentScoreDTO dto = new RentScoreDTO();
		dto.setRscoreNo(rentScoreCommand.getDocumentNo());
		dto.setDepartmentNo(rentScoreCommand.getDepartmentNo());
		dto.setFacScore(rentScoreCommand.getFacScore());
		dto.setPlanScore(rentScoreCommand.getPlanScore());
		dto.setCapScore(rentScoreCommand.getCapScore());
		rentScoreMapper.insertRentScore(dto);
		model.addAttribute("rate", dto);
		Integer total = dto.getCapScore()+dto.getPlanScore()+dto.getFacScore();
		Integer average = total/3;
		String result = "";
		if(average >= 80) {
			result = "합격";
		}else {
			result = "불합격";
		}
		model.addAttribute("total", total);
		model.addAttribute("average", average);
		model.addAttribute("result", result);
	}

}
