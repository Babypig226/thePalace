package finalProject.service.pdorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.command.PdorderCommand;
import finalProject.domain.PdorderDTO;
import finalProject.mapper.PdorderMapper;

@Service
public class PdorderService {
	@Autowired
	PdorderMapper pdorderMapper;

	public void pdorderFormPro(PdorderCommand pdorderCommand) {
		// TODO Auto-generated method stub
		PdorderDTO pordto = new PdorderDTO();
		pordto.setGcompanyNo(pdorderCommand.getGcompanyNo());
		pordto.setGoodsNo(pdorderCommand.getGoodsNo());
		pordto.setOrderNo(pdorderCommand.getOrderNo());
		
		pdorderMapper.pdorderInsert(pordto);
		
	}
	

}
