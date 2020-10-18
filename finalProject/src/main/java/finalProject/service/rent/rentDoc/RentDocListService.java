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
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.RentCompanyMapper;
import finalProject.mapper.RentDocMapper;

@Component
@Service
public class RentDocListService {
	@Autowired
	RentDocMapper rentDocMapper;
	@Autowired
	RentCompanyMapper rentCompanyMapper;
	public void getRentDocList(String spotNo, Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, spotNo);
		List<RentDocDTO> list = rentDocMapper.getRentDocList(dto);
		model.addAttribute("list", list);
		
	}
	public void getMyDocList(HttpSession session, Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, authInfo.getId(), null);
		RentCompanyDTO rdto = rentCompanyMapper.getRentCompanyList(dto).get(0);
		dto.setUserId(null);
		dto.setNum("-"+rdto.getRentalNo()+"-");
		List<RentDocDTO> lists = rentDocMapper.getRentDocList(dto);
		model.addAttribute("list", lists);
		
		
	}

}
