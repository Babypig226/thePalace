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
	
	@RequestMapping("culture")
	public String culture() {
		return "thymeleaf/program/traditional_culture";
	}
	
	@RequestMapping("tour")
	public String tour() {
		return "thymeleaf/program/tour";
	}
	
	@RequestMapping("fitness")
	public String fitness() {
		return "thymeleaf/program/fitness";
	}
	
	@RequestMapping("programList")
	public String programList() {
		return "thymeleaf/program/programList";
	}
	
	@RequestMapping("programInsert")
	public String programInsert() {
		return "thymeleaf/program/programInsert"; 
	}
}
