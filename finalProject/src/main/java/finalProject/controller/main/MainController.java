package finalProject.controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import finalProject.command.LoginCommand;
import finalProject.controller.CookieAction;

@Controller
public class MainController {
	@ModelAttribute
	LoginCommand setLoginCommand() {
        return new LoginCommand();
    }
	
	@RequestMapping(value = "/")
	public String home(HttpServletRequest request,	HttpServletResponse response) {
		CookieAction action = new CookieAction();
		action.execute(request, response);
		return "thymeleaf/index";	
	}
}