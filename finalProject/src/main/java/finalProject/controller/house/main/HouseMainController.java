package finalProject.controller.house.main;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HouseMainController {
	@RequestMapping(value = "houseMain")
	public String home() {
		return "thymeleaf/houseMain";	
	}

}
