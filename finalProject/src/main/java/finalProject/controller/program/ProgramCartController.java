package finalProject.controller.program;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.domain.ProgramDTO;

@Controller
@RequestMapping("prcart")
public class ProgramCartController {

	@RequestMapping("programCartAdd")
	public String programCartAdd() {
		
		return "thymeleaf/program/programCart";
	}
}
