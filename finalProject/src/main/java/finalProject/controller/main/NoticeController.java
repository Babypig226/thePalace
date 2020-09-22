package finalProject.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("notice")
public class NoticeController {
	@RequestMapping("noticeSel")
	public String noticeSel() {
		return "thymeleaf/notice/notice-dep-sel";
	}

}
