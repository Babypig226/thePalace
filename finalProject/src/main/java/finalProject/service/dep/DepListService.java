package finalProject.service.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.DepDTO;
import finalProject.mapper.DepMapper;

@Component
@Service
public class DepListService {
	
	@Autowired
	DepMapper depMapper;
	public void getDepList(Model model) {
		List<DepDTO> list = depMapper.getDepList();
		model.addAttribute("list", list);
		
	}
	
}
