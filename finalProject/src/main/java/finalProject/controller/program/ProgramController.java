package finalProject.controller.program;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import finalProject.command.ProgramListCommand;
import finalProject.service.program.ProgramService;

@Controller
@RequestMapping("program")
public class ProgramController {
	@Autowired
	ProgramService programService;
	
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
	
	@RequestMapping("programForm")
	public String programForm() {
		return "thymeleaf/program/programInsert"; 
	}
	
	@RequestMapping("programInsert")
	public String programInsert(@Validated ProgramListCommand programListCommand,
							BindingResult result, HttpServletRequest request) throws Exception {
		if (result.hasErrors()) {
			System.out.println("programInsert");
			return "thymeleaf/program/programInsert";
		}
		programService.programInsert(programListCommand, request);
		return "redirect:/program/programInsert"; 
	}
	
	@RequestMapping("programDetail")
	public String programDetail() {
		return "thymeleaf/program/programDetail"; 
	}
}
