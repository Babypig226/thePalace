package finalProject.service.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramMapper;

@Component
@Service
public class CultureService {
	@Autowired
	ProgramMapper programMapper;

	public void culture(Model model) {
		List<ProgramDTO> list = programMapper.culture();

		model.addAttribute("list", list);

	}

}
