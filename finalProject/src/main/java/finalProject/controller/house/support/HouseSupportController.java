package finalProject.controller.house.support;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("houseSupport")
public class HouseSupportController {

	@RequestMapping(value = "houseSupport") // 고객센터 
	public String houseSupport() {
		return "thymeleaf/houseSupport/houseSupport";
	}
	
	@RequestMapping(value = "houseCome") // 오시는길 
	public String houseCome() {
		return "thymeleaf/houseSupport/houseCome";
	}
	
	
	
}
