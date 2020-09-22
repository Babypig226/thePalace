package finalProject.service.login;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.AuthInfo;
import finalProject.command.LoginCommand;
import finalProject.domain.MemberDTO;
import finalProject.mapper.MemberMapper;

@Component
@Service
public class LoginService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	AuthInfo authInfo;
	
	public String execute(LoginCommand loginCommand, HttpSession session, 
						HttpServletResponse response, Model model) throws Exception{
		String location = "";
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getUserId());
		List<MemberDTO> lists = memberMapper.selectByMember(member);
		System.out.println("LoginService : " + member.getUserId());
		if(lists.size() == 0) {
			model.addAttribute("valid_user", "아이디가 존재하지 않습니다.");
			location = "thymeleaf/login";
		}else {
			member = lists.get(0);
			if(passwordEncoder.matches(loginCommand.getUserPw(), member.getUserPw())) {
				authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), 
										member.getUserName(), member.getUserPw());
				session.setAttribute("authInfo", authInfo);
				//자동로그인이랑 아이디 저장을 안했음
				Boolean saveID = loginCommand.getSaveID();
				Boolean autologin = loginCommand.getAutologin();
				System.out.println("autologin : "+autologin);
				if(autologin != null && autologin == true) {
					System.out.println("자동로그인 중입니다.");
					Cookie cookie = new Cookie("autologin", authInfo.getId());
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				if(saveID != null && saveID == true) {
					Cookie cookie = new Cookie("saveID", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}else {
					Cookie cookie = new Cookie("saveID", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				location = "redirect:/";
			}else {
				model.addAttribute("valid_pw", "비밀번호가 틀립니다.");
				location = "thymeleaf/login";
			}
		}
		return location;
	}

}
