package finalProject.controller.pdone;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.PdoneCommand;
import finalProject.service.pdone.PdoneDeleteService;
import finalProject.service.pdone.PdoneDetailService;
import finalProject.service.pdone.PdoneListService;
import finalProject.service.pdone.PdoneModifyService;
import finalProject.service.pdone.PdoneWriteService;

@Controller
@RequestMapping("pdone")
public class PdoneController {
	@Autowired
	PdoneWriteService pdoneWriteService;
	@Autowired
	PdoneListService pdoneListService;
	@Autowired
	PdoneDetailService pdoneDetailService;
	@Autowired
	PdoneModifyService pdoneModifyService;
	@Autowired
	PdoneDeleteService pdoneDeleteService;
	
	
	@ModelAttribute
	PdoneCommand setPdoneCommand() {
		return new PdoneCommand();
	}
	
	//service에 있는 값 가져오기 model이가!
	@RequestMapping("pdoneList")
	public String pdoneList(Model model) {
		pdoneListService.pdoneList(model);
		return "thymeleaf/pdone/pdone_to_one";
	}
	
	@RequestMapping(value = "pdonewrite", method = RequestMethod.GET)
	public String pdoneWrite() {
		return "thymeleaf/pdone/pdone_to_one_write";
	}
	
	//페이지에서 등록한것을 command가 값을 넘겨준다 
	@RequestMapping(value = "pdoneWritePro", method = RequestMethod.POST)
	public String pdoneWritePro(PdoneCommand pdoneCommand, HttpSession session) {
		pdoneWriteService.pdWritePro(pdoneCommand,session);
		return "redirect:/pdone/pdoneList";
	}
	
	@RequestMapping("pdoneDetail")
	public String pdoneDetail(@RequestParam (value = "glibNo")String glibNo, Model model) {
		pdoneDetailService.pdoneDetail(glibNo,model);
		return "thymeleaf/pdone/pdone_to_one_detail";
	}
	
	@RequestMapping("pdoneModify")
	public String pdoneModify(@RequestParam (value = "glibNo")String glibNo, Model model) {
		pdoneDetailService.pdoneDetail(glibNo,model);
		return "thymeleaf/pdone/pdone_to_one_modify";
	}
	
	@RequestMapping("pdoneModifyPro")
	public String pdoneModifyPro(PdoneCommand pdoneCommand) {
		pdoneModifyService.pdoneModifyPro(pdoneCommand);
		return "redirect:/pdone/pdoneDetail?glibNo="+pdoneCommand.getGlibNo();
	}
	
	@RequestMapping("pdoneDel")
	public String pdoneDel(@RequestParam (value = "glibNo")String glibNo, Model model) {
		model.addAttribute("glibNo", glibNo);
		return "thymeleaf/pdone/pdone_to_one_delete";
	}
	
	@RequestMapping("pdoneDelPro")
	public String pdoneDelPro(@RequestParam (value = "glibNo")String glibNo, Model model) {
		pdoneDeleteService.poneDel(glibNo,model);
		return "redirect:/pdone/pdoneList";
	}
	
	@RequestMapping("pdoneAnswer")
	public String pdoneAnswer() {
		return "thymeleaf/pdone/pdone_to_one_answer";
	}
	

}
