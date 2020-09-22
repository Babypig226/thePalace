package finalProject.controller.program;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("program")
public class ProgramController {

	@RequestMapping("Made")
	public String made() {
		return "thymeleaf/program/traditional_craft";
	}
}
