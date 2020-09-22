package finalProject.controller.program;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("prmain")
public class ProgramMainController {
	@RequestMapping("programMain")
	public String prmain() {
		return "thymeleaf/programMain";
	}
}
