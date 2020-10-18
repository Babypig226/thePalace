package finalProject.service.rent.rentDoc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.AuthInfo;
import finalProject.domain.RentCompanyDTO;
import finalProject.domain.RentDocDTO;
import finalProject.domain.RentScoreDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.RentCompanyMapper;
import finalProject.mapper.RentDocMapper;
import finalProject.mapper.RentScoreMapper;

@Component
@Service
public class RentDocDetailService {
	@Autowired
	RentDocMapper rentDocMapper;
	@Autowired
	RentCompanyMapper rentCompanyMapper;
	@Autowired
	RentScoreMapper rentScoreMapper;
	public String getRentDocDetail(String documentNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, documentNo);
		RentScoreDTO sdto = rentScoreMapper.getScore(dto).get(0);
		RentDocDTO rdto = rentDocMapper.getRentDocList(dto).get(0);
		dto.setNum(documentNo.split("-")[1]);
		RentCompanyDTO list = rentCompanyMapper.getRentCompanyList(dto).get(0);
		model.addAttribute("list", list);
		model.addAttribute("doc", rdto);
		if(sdto != null) {
			Integer total = sdto.getCapScore()+sdto.getPlanScore()+sdto.getFacScore();
			Integer average = total/3;
			String result = "";
			if(average >= 80) {
				result = "합격";
			}else {
				result = "불합격";
			}
			model.addAttribute("total", total);
			model.addAttribute("average", average);
			model.addAttribute("result", result);
			model.addAttribute("rate", sdto);
			return "thymeleaf/rent/rent-doc-rate-view";
		}else {
			return "thymeleaf/rent/rent-doc-rate";
			
		}
		
	}
	public String getMyRentDocDetail(String documentNo, Model model, HttpSession session) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, documentNo);
		RentDocDTO rdto = rentDocMapper.getRentDocList(dto).get(0);
		List<RentScoreDTO> scoreList = rentScoreMapper.getScore(dto);
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		dto.setUserId(authInfo.getId());
		dto.setNum(null);
		RentCompanyDTO list = rentCompanyMapper.getRentCompanyList(dto).get(0);
		model.addAttribute("list", list);
		model.addAttribute("doc", rdto);
		if(scoreList.size() > 0) {
			Integer total = scoreList.get(0).getCapScore()+scoreList.get(0).getPlanScore()+scoreList.get(0).getFacScore();
			Integer average = total/3;
			String result = "";
			if(average >= 80) {
				result = "합격";
			}else {
				result = "불합격";
			}
			model.addAttribute("total", total);
			model.addAttribute("average", average);
			model.addAttribute("result", result);
			model.addAttribute("rate", scoreList.get(0));
			return "thymeleaf/rent/rent-doc-rate-view";
		}else {
			return "thymeleaf/rent/rent-doc-detail";
			
		}
	}
	
	

}
