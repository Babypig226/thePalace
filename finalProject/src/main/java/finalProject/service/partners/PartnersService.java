package finalProject.service.partners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import finalProject.command.PartnerCommand;
import finalProject.domain.PartnerDTO;
import finalProject.mapper.PartnerMapper;

@Service
public class PartnersService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	PartnerMapper partnerMapper;

	public void ptwritePro(PartnerCommand partnerCommand) {
		// TODO Auto-generated method stub
		PartnerDTO ptdto = new PartnerDTO();
		ptdto.setGcompanyAddr(partnerCommand.getGcompanyAddr());
		ptdto.setGcompanyEmail(partnerCommand.getGcompanyEmail());
		ptdto.setGcompanyId(partnerCommand.getGcompanyId());
		ptdto.setGcompanyName(partnerCommand.getGcompanyName());
		ptdto.setGcompanyNo(partnerCommand.getGcompanyNo());
		ptdto.setGcompanyPh(partnerCommand.getGcompanyPh());
		ptdto.setGcompanyPw(passwordEncoder.encode(partnerCommand.getGcompanyPw()));
		ptdto.setPartnerName(partnerCommand.getPartnerName());
		
		partnerMapper.ptInsert(ptdto);
		
		
		
		
	}

}
