package finalProject.controller.program;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.PgbasketCommand;
import finalProject.service.program.ProgramCartService;

@Controller
@RequestMapping("prcart")
public class ProgramCartController {
	@Autowired
	ProgramCartService programCartService;
	
	@RequestMapping(value = "programCartAdd", method = RequestMethod.POST)
	public String programCartAdd(@RequestParam(value = "programNo") String programNo,
								PgbasketCommand pgbasketCommand,
								Model model, HttpSession session) throws Exception{
		programCartService.programCartAdd(programNo, pgbasketCommand, model, session);
		return "thymeleaf/program/cartsuccess";
	}
	
	@RequestMapping("programCart")
	public String programCart(Model model) throws Exception{
		programCartService.programCartList(model);
		return "thymeleaf/program/programCart";
	}
	
//	@RequestMapping("programPay")
//	public String programPay(@RequestParam(value = "programNo") String programNo,
//							Model model, HttpSession session) {
//		
//	}
	@RequestMapping("test")
	public String test() {
		return "thymeleaf/reference/elements"; 
	}

}
