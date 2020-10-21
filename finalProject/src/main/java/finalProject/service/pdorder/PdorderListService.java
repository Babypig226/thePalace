package finalProject.service.pdorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.PdorderDTO;
import finalProject.mapper.PdorderMapper;

@Service
public class PdorderListService {

	@Autowired
	PdorderMapper pdorderMapper;
	
	public void pdorderList(Model model) {
		// TODO Auto-generated method stub
		List<PdorderDTO> pdolists = pdorderMapper.pdorderList(null);
		
		model.addAttribute("pdolists",pdolists);
	}

}
