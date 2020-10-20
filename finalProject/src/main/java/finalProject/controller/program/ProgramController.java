package finalProject.controller.program;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.FileName;
import finalProject.command.ProgramListCommand;
import finalProject.service.file.FileDelService;
import finalProject.service.program.ProgramDelService;
import finalProject.service.program.ProgramDetailService;
import finalProject.service.program.ProgramListService;
import finalProject.service.program.ProgramModifyService;
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
	@Autowired
	FileDelService fileDelService;
	@Autowired
	ProgramDelService programDelService;
	@Autowired
	ProgramModifyService programModifyService;
	
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
	
	@RequestMapping("programForm")
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
		String location = programService.programInsert(programListCommand, request);
		return location;
	}
	
	@RequestMapping("programDetail")
	public String programDetail(@RequestParam(value = "programNo") String programNo, 
							Model model, HttpSession session) throws Exception{
		programDetailService.programDetail(programNo, session, model);
		return "thymeleaf/program/programDetail"; 
	}
	
	@RequestMapping("programModify")
	public String programModify(@RequestParam("programNo") String programNo,
							Model model, HttpSession session) throws Exception{
		programDetailService.programDetail(programNo, session, model);
		return "thymeleaf/program/programModify";
	}
	
	@RequestMapping("fileDel")
	public String fileDel(FileName imageName, HttpSession session, Model model) throws Exception{
		fileDelService.fileDel(imageName, session, model);
		return "thymeleaf/program/delPage";
	}

	@RequestMapping(value = "proModifyPro", method = RequestMethod.POST)
	public String proModifyPro(ProgramListCommand programListCommand,
							HttpSession session, Model model) throws Exception{
		String path = programModifyService.programModify(programListCommand, session, model);
		return path;
	}

	@RequestMapping("programDel")
	public String programDel(@RequestParam(value = "programNo") String programNo, 
							Model model) throws Exception{
		model.addAttribute("programNo", programNo);
		return "thymeleaf/program/programDelete"; 
	}
	
	@RequestMapping("programDelPro")
	public String programDelPro(@RequestParam(value = "programNo") String programNo,
								@RequestParam(value = "programName") String programName,
								HttpSession session, Model model) throws Exception{
		String path = programDelService.programDel(programNo, programName, session, model);
		return path;
	}
}
