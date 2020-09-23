package finalProject.controller.admin.dep;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import finalProject.command.DepCommand;
import finalProject.service.dep.DepService;

@Controller
@RequestMapping("dep")
public class DepController {
	@Autowired
	DepService depService;
	
	@ModelAttribute
	DepCommand setDepCommand() {
		return new DepCommand();
	};
	
	@RequestMapping("list")
	public String depList() {
		return "thymeleaf/admin-dep/admin-dep-list";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String depRegist() {
		return "thymeleaf/admin-dep/admin-dep-regist";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String depRegistPro(DepCommand depCommand, HttpSession session) {
		depService.depInsert(depCommand, session);
		return "redirect:/dep/list";
	}

}
