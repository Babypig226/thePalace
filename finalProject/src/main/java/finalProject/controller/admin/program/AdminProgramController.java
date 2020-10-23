package finalProject.controller.admin.program;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("proAdmin")
public class AdminProgramController {

	@RequestMapping("adminPage")
	public String proAdmin() {
		return "thymeleaf/admin-program/adminProgram";
	}
}
