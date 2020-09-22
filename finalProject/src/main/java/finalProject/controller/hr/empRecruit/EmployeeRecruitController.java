package finalProject.controller.hr.empRecruit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hr")
public class EmployeeRecruitController {
	@RequestMapping("sel")
	public String categorySelect() {
		return "thymeleaf/apply/apply-select";
	}
	
	@RequestMapping("tutorSel")
	public String tutorSel() {
		return "thymeleaf/apply/tutor-apply";
	}
	
	@RequestMapping("programApp")
	public String programAppList() {
		return "thymeleaf/apply/recruit-tutor-notice-list";
	}
	@RequestMapping("tutorNoticeWrite")
	public String tutorNoticeWrite() {
		return "thymeleaf/apply/recruit-tutor-notice-write";
	}
	
}
