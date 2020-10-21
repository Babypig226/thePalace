package finalProject.service.pdorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PdorderDTO;
import finalProject.mapper.PdorderMapper;

@Service
public class PdorderDetailService {

	@Autowired
	PdorderMapper pdorderMapper;
	
	public void pdorderDetail(String orderNo, Model model) {
		// TODO Auto-generated method stub
	  PdorderDTO pdodto = pdorderMapper.pdorderList(orderNo).get(0);
	  
	  model.addAttribute("pdodto",pdodto);
	}
	

}
