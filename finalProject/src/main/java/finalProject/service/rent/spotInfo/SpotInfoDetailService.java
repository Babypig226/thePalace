package finalProject.service.rent.spotInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.SpotInfoDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.SpotInfoMapper;

@Component
@Service
public class SpotInfoDetailService {
	@Autowired
	SpotInfoMapper spotInfoMapper;

	public void getSpotDetail(String spotNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, spotNo);
		SpotInfoDTO sdto = spotInfoMapper.getSpotList(dto).get(0);
		model.addAttribute("list", sdto);
		
	}
	

}
