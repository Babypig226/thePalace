package finalProject.service.rent.spotInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.SpotCommand;
import finalProject.domain.SpotInfoDTO;
import finalProject.mapper.SpotInfoMapper;

@Component
@Service
public class SpotInfoModifyService {
	@Autowired
	SpotInfoMapper spotInfoMapper;

	public void updateSpot(SpotCommand spotCommand) {
		SpotInfoDTO dto = new SpotInfoDTO(spotCommand.getSpotNo(), spotCommand.getSpotName(), spotCommand.getSpotPurpose(), spotCommand.getSpotPrice());
		spotInfoMapper.updateSpot(dto);
	
	}
	

}
