package finalProject.service.hr.applicants;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.ApplicantCommand;
import finalProject.command.AuthInfo;
import finalProject.domain.ApplicantDTO;
import finalProject.domain.MemberDTO;
import finalProject.mapper.ApplicantMapper;
import finalProject.mapper.MemberMapper;
import finalProject.service.addr.AddressService;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class ApplicantsWriteService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	ApplicantMapper applicantMapper;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	AddressService addressService;

	public String setBasicInfo(String enoticeNo, HttpSession session, Model model)throws Exception {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo == null) {
			return "redirect:/login";
		}else {
			MemberDTO dto = new MemberDTO();
			dto.setUserId(authInfo.getId());
			dto = memberMapper.selectByMember(dto).get(0);
			model.addAttribute("list", dto);
			model.addAttribute("enoticeNo", enoticeNo);
			return "thymeleaf/hr/applicants/applicants-write";
		}
		
		
	}

	public void registApplicant(ApplicantCommand applicantCommand, HttpServletRequest request) throws Exception{
		MemberDTO mdto = new MemberDTO();
		mdto.setUserId(applicantCommand.getApplicantId());
		mdto = memberMapper.selectByMember(mdto).get(0);
		ApplicantDTO dto = new ApplicantDTO();
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddHHmmss");
		String num = dateForm.format(new Date());
		dto.setAcceptNo(applicantCommand.getEnoticeNo()+"-"+num);
		dto.setApplicantId(mdto.getUserId());
		dto.setApplicantPw(mdto.getUserPw());
		dto.setApplicantName(mdto.getUserName());
		dto.setApplicantEname(applicantCommand.getApplicantEname());
		dto.setApplicantBirth(mdto.getUserBirth());
		dto.setApplicantAddr(addressService.updateAddress(applicantCommand.getApplicantAddr()));
		dto.setApplicantPh(applicantCommand.getApplicantPh());
		dto.setApplicantEmail(applicantCommand.getApplicantEmail());
		dto.setPiAgree(applicantCommand.getPiAgree());
		String path = "/static/applicants/upload";
		String filePath = request.getServletContext().getRealPath(path);
		dto.setApplicantContent(fileUploadService.multipleFileUpload(applicantCommand.getApplicantContent(), filePath));
		applicantMapper.registApplicant(dto);
	}
	
	
}
