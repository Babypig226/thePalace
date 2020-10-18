package finalProject.service.rent.spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.RentContractCommand;
import finalProject.domain.SpotDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.RentContractMapper;
import finalProject.mapper.SpotMapper;

@Component
@Service
public class SpotInsertService {
	@Autowired
	RentContractMapper rentContractMapper;
	
	@Autowired
	SpotMapper spotMapper;
	public String insertSpot(RentContractCommand rentContractCommand) {
		SpotDTO dto = new SpotDTO();
		dto.setDocumentNo(rentContractCommand.getDocumentNo());
		dto.setSpotNo(rentContractCommand.getDocumentNo().split("-")[0]);
		StartEndPageDTO sdto = new StartEndPageDTO(1L, 1L, null, rentContractCommand.getDocumentNo());
		dto.setContractNo(rentContractMapper.getRentContractList(sdto).get(0).getContractNo());
		spotMapper.insertSpot(dto);
		return dto.getContractNo();
		
	}
	

}
