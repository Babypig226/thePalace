package finalProject.service.house.fixtures;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.house.FixturesDTO;
import finalProject.mapper.house.fixtures.FixturesMapper;

@Component
@Service
public class FixturesListService {

	@Autowired
	FixturesMapper fixturesMapper;
	
	public void FixturesList(Model model) throws Exception {
		List<FixturesDTO> lists = fixturesMapper.getFixturesList();
		
		model.addAttribute("lists", lists);
	}

}
