package finalProject.controller.program;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import finalProject.command.ProResCommand;
import finalProject.command.ProgramPayCommand;
import finalProject.service.program.ProPayResService;
import finalProject.service.program.ProgramCartService;
import finalProject.service.program.ProgramPayService;
import finalProject.service.program.ProgramResService;

@Controller
@RequestMapping("programPay")
public class ProgramPayController {
	@Autowired
	ProgramCartService programCartService;
	@Autowired
	ProgramResService programResService;
	@Autowired
	ProgramPayService programPayService;
	@Autowired
	ProPayResService proPayResService;
	
	@RequestMapping("directPay")
	public String directPay(Model model, HttpSession session) throws Exception{
		programCartService.programCartList(model);
		return "thymeleaf/programOrder/orderPay";
	}
	
	@RequestMapping(value = "payInfoInsert", method = RequestMethod.POST)
	public String payInfoInsert(@Validated ProResCommand proResCommand,
							Model model, HttpSession session) throws Exception{
		programResService.resInfoInsert(proResCommand, model, session);
		return "redirect:/programPay/payInfo";
	}
	
	@RequestMapping(value = "payInfo", method = RequestMethod.GET)
	public String payInfo(Model model) throws Exception{
		programCartService.programCartList(model);
		return "thymeleaf/programOrder/payInfoForm";
	}
	
	@RequestMapping(value = "payInfoWrite", method = RequestMethod.POST)
	public String payInfoWrite(@Validated ProgramPayCommand programPayCommand,
							Model model, HttpSession session) throws Exception{
		programPayService.payInfoInsert(programPayCommand, model, session);
		return "redirect:/programPay/finalInfo";
	}
	
	@RequestMapping("finalInfo")
	public String finalInfo(Model model, HttpSession session, String userId) throws Exception{
		//proPayResService.payresInsert();
		programResService.resInfoList(model);
		programPayService.payInfoList(model);
		programCartService.programCartList(model);
		programCartService.programCartDel(session, userId);
		return "thymeleaf/programOrder/finalInfo";
	}
}
