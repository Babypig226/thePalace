package finalProject.service.partners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PartnerDTO;
import finalProject.mapper.PartnerMapper;

@Service
public class PartnersDetailService {
  @Autowired
  PartnerMapper partnerMapper;
	public void ptdetail(String gcompanyNo, Model model) {
		// TODO Auto-generated method stub
		
		PartnerDTO pdto = partnerMapper.ptlist(gcompanyNo).get(0);
		model.addAttribute("pdto",pdto);
	}
	

}
