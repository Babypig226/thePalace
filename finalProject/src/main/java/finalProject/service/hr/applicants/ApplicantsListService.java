package finalProject.service.hr.applicants;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.AuthInfo;
import finalProject.domain.ApplicantDTO;
import finalProject.domain.EmpInterviewDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ApplicantMapper;
import finalProject.mapper.EmpInterviewMapper;
import finalProject.mapper.EmployeeMapper;
import finalProject.mapper.EnoticeMapper;

@Component
@Service
public class ApplicantsListService {
	@Autowired
	ApplicantMapper applicantMapper;
	@Autowired
	EnoticeMapper enoticeMapper;
	@Autowired
	EmpInterviewMapper empInterviewMapper;
	@Autowired
	EmployeeMapper employeeMapper;

	public void getApplicantsList(String enoticeNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, enoticeNo);
		List<ApplicantDTO> adto = applicantMapper.getApplicantsList(dto); 
		for (int i = 0; i < adto.size(); i++) {
			dto.setNum(adto.get(i).getAcceptNo().split("-")[0]);
			adto.get(i).setEnoticeName(enoticeMapper.getEnoticeList(dto).get(0).getEnoticeName());
			dto.setNum(adto.get(i).getAcceptNo());
			EmpInterviewDTO empdto = empInterviewMapper.getScore(dto);
			if(empdto != null) {
				if(empdto.getPaperScore() != null || empdto.getPaperScore() >= 0) {
					if(empdto.getPaperScore()>5) {
						adto.get(i).setPaperResult("서류합격");
						if(empdto.getInterviewScore() == null) {
							adto.get(i).setFinalResult("미심사");
						}else {
							if(empdto.getTotScore()>12) {
								adto.get(i).setFinalResult("최종합격");
							}else {
								adto.get(i).setFinalResult("불합격");
							}
						}
					}else {
						adto.get(i).setPaperResult("불합격");
					}
				}
					
				
			}else {
				adto.get(i).setPaperResult("미심사");
				adto.get(i).setFinalResult("미심사");
			}
		}
		model.addAttribute("list", adto);
	}

	public void getMyList(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, authInfo.getId(), null);
		List<ApplicantDTO> adto = applicantMapper.getApplicantsList(dto);
		dto.setUserId(null);
		for (int i = 0; i < adto.size(); i++) {
			dto.setNum(adto.get(i).getAcceptNo().split("-")[0]);
			adto.get(i).setEnoticeName(enoticeMapper.getEnoticeList(dto).get(0).getEnoticeName());
			dto.setNum(adto.get(i).getAcceptNo());
			EmpInterviewDTO empdto = empInterviewMapper.getScore(dto);
			if(empdto != null) {
				if(empdto.getPaperScore() != null || empdto.getPaperScore() >= 0) {
					if(empdto.getPaperScore()>5) {
						adto.get(i).setPaperResult("서류합격");
						if(empdto.getInterviewScore() == null) {
							adto.get(i).setFinalResult("미심사");
						}else {
							if(empdto.getTotScore()>12) {
								adto.get(i).setFinalResult("최종합격");
							}else {
								adto.get(i).setFinalResult("불합격");
							}
						}
					}else {
						adto.get(i).setPaperResult("불합격");
					}
				}
					
				
			}else {
				adto.get(i).setPaperResult("미심사");
				adto.get(i).setFinalResult("미심사");
			}
		}
		model.addAttribute("list", adto);
		
	}

	public void getFinalists(Model model) {
		List<ApplicantDTO> finalists = applicantMapper.getFinalists();
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, null);
		for (int i = 0; i < finalists.size(); i++) {
			dto.setUserId(finalists.get(i).getApplicantId());
			if(!employeeMapper.getEmpList(dto).isEmpty()) {
				finalists.remove(i);
			}else {
				dto.setUserId(null);
				dto.setNum(finalists.get(i).getAcceptNo().split("-")[0]);
				finalists.get(i).setEnoticeName(enoticeMapper.getEnoticeList(dto).get(0).getEnoticeName());
			}
		}

		model.addAttribute("list", finalists);
		
	}
	
	

}
