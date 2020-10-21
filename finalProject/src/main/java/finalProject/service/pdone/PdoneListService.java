package finalProject.service.pdone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PdoneDTO;
import finalProject.mapper.PdoneMapper;

@Service
public class PdoneListService {

	@Autowired
	PdoneMapper pdoneMapper;
	
	public void pdoneList(Model model) {
		// TODO Auto-generated method stub
		List<PdoneDTO> polists = pdoneMapper.poList(null);
		model.addAttribute("polists",polists);
	}

}
