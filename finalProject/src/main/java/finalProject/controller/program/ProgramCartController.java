package finalProject.controller.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.service.program.ProgramCartService;

@Controller
@RequestMapping("prcart")
public class ProgramCartController {
	@Autowired
	ProgramCartService programCartService;
	
	@RequestMapping(value = "programCartAdd")
	public String programCartAdd(@RequestParam(value = "programNo") String programNo) throws Exception{
		programCartService.programCartAdd(programNo);
		return "redirect:/prcart/programCart";
	}
	
	@RequestMapping("programCart")
	public String programCart(Model model) throws Exception{
		programCartService.programCartList(model);
		return "thymeleaf/program/programCart"; 
	}

}
