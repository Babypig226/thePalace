package finalProject.service.hr.applicants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.ApplicantDTO;
import finalProject.domain.EnoticeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ApplicantMapper;
import finalProject.mapper.EnoticeMapper;

@Component
@Service
public class ApplicantsListService {
	@Autowired
	ApplicantMapper applicantMapper;
	@Autowired
	EnoticeMapper enoticeMapper;

	public void getApplicantsList(String enoticeNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, enoticeNo);
		List<ApplicantDTO> adto = applicantMapper.getApplicantsList(dto); 
		EnoticeDTO edto =  enoticeMapper.getEnoticeList(dto).get(0);
		model.addAttribute("list", adto);
		model.addAttribute("enoticeName", edto.getEnoticeName());
	}
	
	

}
