package finalProject.controller.hr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recruit")
public class RecruitController {
	
	@RequestMapping("sel")
	public String hrSelect() {
		return "thymeleaf/notice/hr-select";
	}
	
	@RequestMapping("tutorSel")
	public String tutorSel() {
		return "thymeleaf/notice/t-category-sel";
	}
	
	
	
}
