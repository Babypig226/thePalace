package finalProject.service.rent.spotInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.SpotInfoMapper;

@Component
@Service
public class SpotInfoDeleteService {
	@Autowired
	SpotInfoMapper spotInfoMapper;

	public void deleteSpot(String spotNo) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, spotNo);
		spotInfoMapper.deleteSpot(dto);
		
	}
	

}
