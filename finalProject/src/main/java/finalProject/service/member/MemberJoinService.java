package finalProject.service.member;

import java.sql.Timestamp;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import finalProject.command.MemberCommand;
import finalProject.controller.MailAction;
import finalProject.controller.SmsSend;
import finalProject.domain.MemberDTO;
import finalProject.mapper.MemberMapper;

@Component
@Service
@Transactional
public class MemberJoinService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	MailAction mailAction;
	@Autowired
	MemberMapper memberRepository;
	
	public Integer joinOkUpdate(String joinOk, String reciver, String userId) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setJoinOk(joinOk);
		memberDTO.setUserEmail(reciver);
		memberDTO.setUserId(userId);
		return memberRepository.joinOkUpdate(memberDTO);
	}
	
	public Integer insertMember(MemberCommand memberCommand, Model model) {
		if(!memberCommand.isUserPwEqualToUserPwCon()) {
			model.addAttribute("valid_userPwCon", "비밀번호가 일치하지 않습니다.");
			return null;
		}
		Integer result = null;
		MemberDTO memberDTO = new MemberDTO();
		Timestamp userBirth = Timestamp.valueOf(memberCommand.getUserBirth());
		memberDTO.setUserPw(passwordEncoder.encode(memberCommand.getUserPw()));
		memberDTO.setUserBirth(userBirth);
		memberDTO.setUserAddr(memberCommand.getUserAddr());
		memberDTO.setUserEmail(memberCommand.getUserEmail());
		memberDTO.setUserGender(memberCommand.getUserGender());
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserName(memberCommand.getUserName());
		memberDTO.setUserAge(memberCommand.getUserAge());
		memberDTO.setUserPh(memberCommand.getUserPh());
		try {
			result = memberMapper.insertMember(memberDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result != null) {
			SmsSend ss = new SmsSend();
			try {
				mailAction.sendMail(memberDTO.getUserEmail(), memberDTO.getUserId());
				ss.smsSend(memberDTO.getUserPh(), memberDTO.getUserName()+"님 회원을 축하합니다.");
			} catch (MessagingException e) {
				ss.smsSend(memberDTO.getUserPh(), memberDTO.getUserName()+"님 1234-1234로 문의바랍니다.");
				e.printStackTrace();
			}
		}else {
			model.addAttribute("duplicate_userId", "사용중인 아이디입니다.");
		}
		return result;
	}
}
