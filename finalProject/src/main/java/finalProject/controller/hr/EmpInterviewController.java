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
	@RequestMapping("regist")
	public String empInterviewRegist(@RequestParam(value = "acceptNo")String acceptNo, EmpInterviewCommand empInterviewCommand) {
		empInterviewRegistService.registScore(acceptNo, empInterviewCommand);
		return "redirect:/apply/view?acceptNo="+acceptNo;
	}
	

}
