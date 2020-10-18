package finalProject.service.hr.applicants;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.AddressDTO;
import finalProject.domain.ApplicantDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ApplicantMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class ApplicantDetailService {
	@Autowired
	ApplicantMapper applicantMapper;
	@Autowired
	AddressService addressService;

	public void getApplicantDetail(String acceptNo, Model model) {
		String[] num = acceptNo.split("-");
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, num[0]);
		ApplicantDTO adto = applicantMapper.getApplicantsList(dto).get(0);
		adto.setApplicantAddr(addressService.rebuildAddress(adto.getApplicantAddr()));
		String[] fileList = adto.getApplicantContent().split("`");
		model.addAttribute("list", adto);
		model.addAttribute("fileList", fileList);
	}

	public void searchById(String applicantId, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, applicantId, null);
		ApplicantDTO adto = applicantMapper.getApplicantsList(dto).get(0);
		AddressDTO addr = addressService.devideAddress(adto.getApplicantAddr());
		System.out.println("searchById"+adto.getApplicantPh());
		model.addAttribute("list", adto);
		model.addAttribute("addr", addr);
		
	}
	
	

}
