package finalProject.service.house.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.house.FixturesDTO;
import finalProject.mapper.house.fixtures.FixturesMapper;

@Component
@Service
public class FixturesViewService {

	@Autowired
	FixturesMapper fixturesMapper;
	
	public void fixturesView(String equipNo, Model model) throws Exception {
		
		FixturesDTO dto = fixturesMapper.getFixturesView(equipNo);
		
		model.addAttribute("dto",dto);
		
	}

}
