package finalProject.service.pdorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.command.PdorderCommand;
import finalProject.domain.PdorderDTO;
import finalProject.mapper.PdorderMapper;

@Service
public class PdorderModifyService {
	@Autowired
	PdorderMapper pdorderMapper;

	public void pdorderModifyPro(PdorderCommand pdorderCommand) {
		// TODO Auto-generated method stub
		PdorderDTO pdodto = new PdorderDTO();
		pdodto.setGoodsNo(pdorderCommand.getGoodsNo());
		pdodto.setOrderNo(pdorderCommand.getOrderNo());
		
		pdorderMapper.pdorderUpdate(pdodto);
	}
	

}
