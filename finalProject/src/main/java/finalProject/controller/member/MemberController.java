package finalProject.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.MemberCommand;
import finalProject.service.member.MemberJoinService;

@Controller
@RequestMapping("sign-up")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@ModelAttribute
	MemberCommand setMemberCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value = "member-agree", method = RequestMethod.GET)
	public String agree() {
		return "thymeleaf/sign-up/member-agree";
	}
	
	@RequestMapping(value = "member-form", method = RequestMethod.POST)
	public String memberForm() {
		return "thymeleaf/sign-up/member-form";
	}
	
	@RequestMapping(value = "regist-ok", method = RequestMethod.POST)
	public String memberJoin(@Validated MemberCommand memberCommand,
						BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/sign-up/member-form"; 
		}
		Integer i = memberJoinService.insertMember(memberCommand, model);
		if(i == null) return "thymeleaf/sign-up/member-form";
		return "redirect:/";
	}
	
	@RequestMapping(value = "memberMail", method = RequestMethod.GET)
	public String memberMail(@RequestParam(value = "num") String joinOk,
							@RequestParam(value = "reciver") String reciver,
							@RequestParam(value = "userId") String userId) {
		Integer i = memberJoinService.joinOkUpdate(joinOk, reciver, userId);
		if(i > 0) {
			return "thymeleaf/sign-up/mail-success";
		}else {
			return "thymeleaf/sign-up/mail-done";
		}
		
	}
}
