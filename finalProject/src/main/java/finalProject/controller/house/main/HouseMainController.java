package finalProject.controller.house.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import finalProject.controller.CookieAction;

@Controller
public class HouseMainController {
	@RequestMapping(value = "houseMain")
	public String home(HttpServletRequest request,	HttpServletResponse response) {
		CookieAction action = new CookieAction();
		action.execute(request, response);
		return "thymeleaf/house/houseMain";	
	}

}
