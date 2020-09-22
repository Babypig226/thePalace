package finalProject.controller.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sign")
public class LogOutController {
	@RequestMapping(value = "out")
	public String logout(HttpSession session, HttpServletResponse response) {
		Cookie autoLoginCookie = new Cookie("autologin", "");
		autoLoginCookie.setPath("/");
		autoLoginCookie.setMaxAge(0);
		response.addCookie(autoLoginCookie);
		session.invalidate();
		return "redirect:/";
	}

}
