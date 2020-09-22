package finalProject.controller.program;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pgmypage")
public class PgMypageController {
	
	@RequestMapping("programMypage")
	public String myPage() {
		return "thymeleaf/program/programMypage";
	}
}
