package finalProject.service.house.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.mapper.house.fixtures.FixturesMapper;

@Component
@Service
public class FixturesDeleteSerivce {
	@Autowired
	FixturesMapper fixturesMapper;
	
	public void fixturesDeletePro(String equipNo, Model model) throws Exception {
		
		model.addAttribute("equipNo", equipNo);
		
		fixturesMapper.fixturesDelete(equipNo);
	}
	 
}
