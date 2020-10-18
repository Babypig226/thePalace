package finalProject.controller.admin.dep;

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

import finalProject.command.DepCommand;
import finalProject.service.dep.DepDeleteService;
import finalProject.service.dep.DepDetailService;
import finalProject.service.dep.DepListService;
import finalProject.service.dep.DepModService;
import finalProject.service.dep.DepService;

@Controller
@RequestMapping("dep")
public class DepController {
	@Autowired
	DepService depService;
	@Autowired
	DepListService depListService;
	@Autowired
	DepDetailService depDetailService;
	@Autowired
	DepModService	depModService;
	@Autowired
	DepDeleteService depDeleteService;
	
	@ModelAttribute
	DepCommand setDepCommand() {
		return new DepCommand();
	};
	
	@RequestMapping("list")
	public String depList(@RequestParam(value = "page", defaultValue = "1")Integer page, Model model) {
		depListService.getDepList(model, page);
		return "thymeleaf/admin-dep/admin-dep-list";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String depRegist() {
		return "thymeleaf/admin-dep/admin-dep-regist";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String depRegistPro(@Validated DepCommand depCommand, HttpSession session, BindingResult result) {
		System.out.println(result.getErrorCount());
		if(result.hasErrors()) {
			return "thymeleaf/admin-dep/admin-dep-regist";
		}else {
			
			depService.depInsert(depCommand, session);
			return "redirect:/dep/list";
		}
	}
	
	@RequestMapping("view")
	public String depDetail(@RequestParam(value = "dpNo")String dpNo, Model model) {
		depDetailService.depDetail(dpNo, model);
		return "thymeleaf/admin-dep/admin-dep-detail";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String depModify(@RequestParam(value = "dpNo")String dpNo, Model model) {
		depDetailService.depDetail(dpNo, model);
		return "thymeleaf/admin-dep/admin-dep-modify";
		
	}
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String depModifyPro(DepCommand depCommand) {
		depModService.depModify(depCommand);
		return "redirect:/dep/list";
	}
	
	@RequestMapping("delete")
	public String depDelete(@RequestParam(value = "dpNo")String departmentNo) {
		depDeleteService.deleteDep(departmentNo);
		return "redirect:/dep/list";
	}
	

}
