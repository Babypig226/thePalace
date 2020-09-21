package finalProject.controller.houseschedule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hschedule")
public class HouseScheduleController {
	
	@RequestMapping("schedule")
	public String form() throws Exception {
		return "thymeleaf/schedule/schedule";
	}
}
