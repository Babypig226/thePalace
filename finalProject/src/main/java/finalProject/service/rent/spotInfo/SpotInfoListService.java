package finalProject.service.rent.spotInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.SpotInfoDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.SpotInfoMapper;

@Component
@Service
public class SpotInfoListService {
	@Autowired
	SpotInfoMapper spotInfoMapper;

	public void getSpotList(Integer page, String type, Model model) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, type);
		List<SpotInfoDTO> lists = spotInfoMapper.getSpotList(dto);
		for (int i = 0; i < lists.size(); i++) {
			System.out.println("list : spotName "+lists.get(i).getSpotName());
		}
		if(type.equals("s")) {
			model.addAttribute("type", "단기");
		}else {
			model.addAttribute("type", "장기");
		}
		model.addAttribute("list", lists);
		
	}
	

}
