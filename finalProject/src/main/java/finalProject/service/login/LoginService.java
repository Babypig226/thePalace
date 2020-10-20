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
import finalProject.domain.ApplicantDTO;
import finalProject.domain.EmployeeDTO;
import finalProject.domain.MemberDTO;
import finalProject.domain.RentCompanyDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ApplicantMapper;
import finalProject.mapper.EmployeeMapper;
import finalProject.mapper.MemberMapper;
import finalProject.mapper.RentCompanyMapper;

@Component
@Service
public class LoginService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	RentCompanyMapper rentCompanyMapper;
	@Autowired
	ApplicantMapper applicantMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	AuthInfo authInfo;
	
	public String execute(LoginCommand loginCommand, HttpSession session, 
						HttpServletResponse response, Model model) throws Exception{
		String location = "";
		
		StartEndPageDTO dto = new StartEndPageDTO(1l, 1l, loginCommand.getUserId(), null);
		List<RentCompanyDTO> rclist = rentCompanyMapper.getRentCompanyList(dto);
		List<ApplicantDTO> aplist = applicantMapper.getApplicantsList(dto);
		List<EmployeeDTO> emplist = employeeMapper.getEmpList(dto);
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getUserId());
		List<MemberDTO> lists = memberMapper.selectByMember(member);
		if(lists.size() == 0 && rclist.size() == 0) {
			model.addAttribute("valid_user", "아이디가 존재하지 않습니다.");
			location = "thymeleaf/login";
		}else if(lists.size()>0){
			member = lists.get(0);
			if(passwordEncoder.matches(loginCommand.getUserPw(), member.getUserPw())) {
				if(aplist.size()==0 && emplist.size() == 0) {
					authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), 
							member.getUserName(), member.getUserPw(), "mem");
				}else if(emplist.size()>0) {
					authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), 
							member.getUserName(), member.getUserPw(), "adm");
				}else if(aplist.size()>0){
					authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), 
							member.getUserName(), member.getUserPw(), "app");
				}
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
			
		}else if(rclist.size() > 0){
		if(passwordEncoder.matches(loginCommand.getUserPw(), rclist.get(0).getRentalPw())) {
		authInfo = new AuthInfo(rclist.get(0).getRentalId(), null, rclist.get(0).getRentalName(), rclist.get(0).getRentalPw(), "rc");
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
