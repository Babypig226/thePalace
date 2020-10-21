package finalProject.service.partners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.command.PartnerCommand;
import finalProject.domain.PartnerDTO;
import finalProject.mapper.PartnerMapper;

@Service
public class PartnersModifyService {
	
	@Autowired
	PartnerMapper partnerMapper;

	public void ptModifyPro(PartnerCommand partnerCommand) {
		// TODO Auto-generated method stub
		
		PartnerDTO ptdto = new PartnerDTO();
	   ptdto.setPartnerName(partnerCommand.getPartnerName());
	   ptdto.setGcompanyPh(partnerCommand.getGcompanyPh());
	   ptdto.setGcompanyAddr(partnerCommand.getGcompanyAddr());
	   ptdto.setGcompanyEmail(partnerCommand.getGcompanyEmail());
	   ptdto.setGcompanyNo(partnerCommand.getGcompanyNo());
	   
	   
	   partnerMapper.ptmodify(ptdto);
	   
	   
		
		
	}

}
