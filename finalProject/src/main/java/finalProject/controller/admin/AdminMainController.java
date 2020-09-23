package finalProject.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminMainController {
	@RequestMapping("view")
	public String adminView() {
		return "thymeleaf/admin-manage/admin-view";
	}
	

}
