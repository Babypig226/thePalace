package finalProject.controller.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.EmpInterviewCommand;
import finalProject.service.hr.empInterview.EmpInterviewRegistService;

@Controller
@RequestMapping("empIntv")
public class EmpInterviewController {
	@Autowired
	EmpInterviewRegistService empInterviewRegistService;
	@RequestMapping("paperRate")
	public String empInterviewRegist(@RequestParam(value = "acceptNo")String acceptNo, EmpInterviewCommand empInterviewCommand) {
		empInterviewRegistService.registPaperScore(acceptNo, empInterviewCommand);
		return "redirect:/apply/list?enoticeNo="+acceptNo.split("-")[0];
	}
	@RequestMapping("interviewRate")
	public String empInterviewUpdate(@RequestParam(value = "acceptNo")String acceptNo, EmpInterviewCommand empInterviewCommand) {
		empInterviewRegistService.updateScore(acceptNo, empInterviewCommand);
		return "redirect:/apply/list?enoticeNo="+acceptNo.split("-")[0];
	}
	

}
