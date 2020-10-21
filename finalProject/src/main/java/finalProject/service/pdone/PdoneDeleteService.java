package finalProject.service.pdone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PdoneDTO;
import finalProject.mapper.PdoneMapper;

@Service
public class PdoneDeleteService {

	@Autowired
	PdoneMapper pdoneMapper;
	
	public void poneDel(String glibNo, Model model) {
		// TODO Auto-generated method stub
	
	 PdoneDTO podto = pdoneMapper.poList(glibNo).get(0);
	 
	 pdoneMapper.pdoneDel(glibNo);
			 
			 
		
	}

}
