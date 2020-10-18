package finalProject.service.rent.rentCompany;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.AuthInfo;
import finalProject.domain.RentCompanyDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.RentCompanyMapper;

@Component
@Service
public class RentCompanyDetailService {
	@Autowired
	RentCompanyMapper rentCompanyMapper;
	public void getRentCompanyInfo(HttpSession session, Model model, String depNo, String spotNo) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, authInfo.getId(), null);
		RentCompanyDTO rdto = rentCompanyMapper.getRentCompanyList(dto).get(0);
		model.addAttribute("list", rdto);
		model.addAttribute("depNo", depNo);
		model.addAttribute("spotNo", spotNo);
	}

}
