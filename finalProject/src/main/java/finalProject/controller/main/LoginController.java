package finalProject.controller.main;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import finalProject.command.LoginCommand;
import finalProject.service.login.LoginService;

@Controller
@RequestMapping(value = "/")
public class LoginController { 
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "thymeleaf/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String submit(@Validated LoginCommand loginCommand,BindingResult result, HttpSession session,
						HttpServletResponse response, Model model) throws Exception{
		if(result.hasErrors()) {
			return "thymeleaf/login"; 
		}
		String location = loginService.execute(loginCommand, session, response, model);
		return location;
	}
}
