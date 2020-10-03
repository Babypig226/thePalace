package finalProject.controller.program;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.ProgramListCommand;
import finalProject.service.program.ProgramDetailService;
import finalProject.service.program.ProgramListService;
import finalProject.service.program.ProgramService;

@Controller
@RequestMapping("program")
public class ProgramController {
	@Autowired
	ProgramService programService;
	@Autowired
	ProgramListService programListService;
	@Autowired
	ProgramDetailService programDetailService;
	
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
	public String programList(@RequestParam(value = "page", defaultValue = "1") Integer page,
							Model model) throws Exception{
		programListService.programList(model, page);
		return "thymeleaf/program/programList";
	}
	
	@RequestMapping(value = "programForm", method = RequestMethod.GET)
	public String programForm() {
		return "thymeleaf/program/programInsert"; 
	}
	
	@RequestMapping(value = "programInsert", method = RequestMethod.POST)
	public String programInsert(@Validated ProgramListCommand programListCommand,
							BindingResult result, HttpServletRequest request) throws Exception {
		if (result.hasErrors()) {
			System.out.println("programInsert오류");
			return "thymeleaf/program/programInsert";
		}
		programService.programInsert(programListCommand, request);
		return "redirect:/program/programList"; 
	}
	
	@RequestMapping("programDetail")
	public String programDetail(@RequestParam(value = "programNo") String programNo, 
							Model model, HttpSession session) throws Exception{
		programDetailService.programDetail(programNo, session, model);
		return "thymeleaf/program/programDetail"; 
	}
	
//	@RequestMapping(value = "programModify")
//	public String programModify(@RequestParam("programNo") String programNo,
//							Model model) throws Exception{
//		programDetailService.programDetail(programNo, model);
//		return "thymeleaf/program/programModify";
//	}
//	
//	@RequestMapping(value="programModifyPro", method = RequestMethod.POST)
//	public String programModifyPro(ProgramListCommand programListCommand,
//								Model model) throws Exception{
//		programModifyService.programModify(programListCommand, model);
//	}
//	
}
