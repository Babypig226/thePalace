package finalProject.service.rent.spotInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.SpotCommand;
import finalProject.domain.SpotInfoDTO;
import finalProject.mapper.SpotInfoMapper;

@Component
@Service
public class SpotInfoInsertService {
	@Autowired
	SpotInfoMapper spotInfoMapper;
	public void insertSpot(SpotCommand spotCommand) {
		SimpleDateFormat dateForm = new SimpleDateFormat("yyMMddHHmmss");
		String num = dateForm.format(new Date());
		SpotInfoDTO dto = new SpotInfoDTO(spotCommand.getSpotNo()+"-"+num, spotCommand.getSpotName(), spotCommand.getSpotPurpose(), spotCommand.getSpotPrice());
		spotInfoMapper.insertSpot(dto);
		
	}

}
