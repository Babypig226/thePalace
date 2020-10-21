package finalProject.service.partners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PartnerDTO;
import finalProject.mapper.PartnerMapper;

@Service
public class PartnersListService {
	@Autowired
	PartnerMapper partnerMapper;

	public void ptList(Model model) {
		// TODO Auto-generated method stub
		List<PartnerDTO> lists = partnerMapper.ptlist(null);
		model.addAttribute("lists",lists);
		
	}

}
