package finalProject.service.rent.rentDoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.RentDocDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.RentDocMapper;

@Component
@Service
public class RentDocListService {
	@Autowired
	RentDocMapper rentDocMapper;
	public void getRentDocList(String spotNo, Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, spotNo);
		List<RentDocDTO> list = rentDocMapper.getRentDocList(dto);
		model.addAttribute("list", list);
		
	}

}
