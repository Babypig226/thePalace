package finalProject.service.pdone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.command.PdoneCommand;
import finalProject.domain.PdoneDTO;
import finalProject.mapper.PdoneMapper;

@Service
public class PdoneModifyService {
	@Autowired
	PdoneMapper pdoneMapper;

	public void pdoneModifyPro(PdoneCommand pdoneCommand) {
		// TODO Auto-generated method stub
		
		PdoneDTO podto = new PdoneDTO();
		podto.setGlibSubject(pdoneCommand.getGlibSubject());
		podto.setGlibContent(pdoneCommand.getGlibContent());
		podto.setGoodsNo(pdoneCommand.getGoodsNo());
		podto.setGlibNo(pdoneCommand.getGlibNo());
		
		pdoneMapper.poneUpdate(podto);
		
		
		
	}

}
