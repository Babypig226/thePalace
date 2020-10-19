package finalProject.service.hr.applicants;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.AddressDTO;
import finalProject.domain.ApplicantDTO;
import finalProject.domain.EmpInterviewDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ApplicantMapper;
import finalProject.mapper.EmpInterviewMapper;
import finalProject.mapper.EnoticeMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class ApplicantDetailService {
	@Autowired
	ApplicantMapper applicantMapper;
	@Autowired
	EnoticeMapper enoticeMapper;
	@Autowired
	EmpInterviewMapper empInterviewMapper;
	@Autowired
	AddressService addressService;

	public String getApplicantDetail(String acceptNo, Model model) {
		String[] num = acceptNo.split("-");
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, num[0]);
		ApplicantDTO adto = applicantMapper.getApplicantsList(dto).get(0);
		adto.setApplicantAddr(addressService.rebuildAddress(adto.getApplicantAddr()));
		String[] fileList = adto.getApplicantContent().split("`");
		dto.setNum(acceptNo);
		model.addAttribute("list", adto);
		model.addAttribute("fileList", fileList);
		EmpInterviewDTO empdto = empInterviewMapper.getScore(dto);
		if(empdto != null && empdto.getInterviewScore() == null) {
			model.addAttribute("score", empdto);
			return "thymeleaf/hr/applicants/admin-applicants-paperscored";
		}else if(empdto != null && empdto.getInterviewScore() > 0){
			model.addAttribute("score", empdto);
			return "thymeleaf/hr/applicants/admin-applicants-scored";
		}else{
			return "thymeleaf/hr/applicants/applicants-detail";
		}
		
	}

	public void searchById(String applicantId, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, applicantId, null);
		ApplicantDTO adto = applicantMapper.getApplicantsList(dto).get(0);
		AddressDTO addr = addressService.devideAddress(adto.getApplicantAddr());
		System.out.println("searchById"+adto.getApplicantPh());
		model.addAttribute("list", adto);
		model.addAttribute("addr", addr);
		
	}

	public void getMyApplicantDetail(String acceptNo, Model model) {
		String[] num = acceptNo.split("-");
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, num[0]);
		ApplicantDTO adto = applicantMapper.getApplicantsList(dto).get(0);
		adto.setApplicantAddr(addressService.rebuildAddress(adto.getApplicantAddr()));
		adto.setEnoticeName(enoticeMapper.getEnoticeList(dto).get(0).getEnoticeName());
		String[] fileList = adto.getApplicantContent().split("`");
		model.addAttribute("list", adto);
		model.addAttribute("fileList", fileList);
		
	}
	
	

}
