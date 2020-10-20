package finalProject.controller.program;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.service.program.ProgramWishService;

@Controller
@RequestMapping("prwish")
public class ProgramWishController {
	@Autowired
	ProgramWishService programWishService;
	
	@RequestMapping("programWish")
	public String programWish(Model model) throws Exception{
		programWishService.programWishList(model);
		return "thymeleaf/program/programWish";
	}
	
	@RequestMapping("programWishAdd")
	public String prWishAdd(@RequestParam("programNo") String programNo,
							Model model, HttpSession session) throws Exception{
		programWishService.programWishAdd(programNo, model, session);
		return "thymeleaf/program/cartsuccess"; 
	}
	//@{../prcart/programCartAdd(programNo=${prodto.programNo})}
}
