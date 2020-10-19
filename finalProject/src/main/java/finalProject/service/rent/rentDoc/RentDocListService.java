package finalProject.service.rent.rentDoc;

import java.util.ArrayList;
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
public class RentDocListService {
	@Autowired
	RentDocMapper rentDocMapper;
	@Autowired
	RentCompanyMapper rentCompanyMapper;
	@Autowired
	RentScoreMapper rentScoreMapper;
	public void getRentDocList(Model model, Integer page) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, null);
		List<RentDocDTO> lists = rentDocMapper.getRentDocList(dto);
		for (int i = 0; i < lists.size(); i++) {
			dto.setNum(lists.get(i).getDocumentNo());
			List<RentScoreDTO> scoreLists = rentScoreMapper.getScore(dto);
			if(scoreLists.size()==0) {
				lists.get(i).setResult("미심사");
			}else {
				int totalscore = scoreLists.get(0).getCapScore()+scoreLists.get(0).getFacScore()+scoreLists.get(0).getPlanScore();
				int avrg = totalscore/3;
				if(avrg >= 80) {
					lists.get(i).setResult("합격");
				}else if(avrg < 80){
					lists.get(i).setResult("불합격");
				}
				
			}
		}
		model.addAttribute("list", lists);
		
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
		for (int i = 0; i < lists.size(); i++) {
			dto.setNum(lists.get(i).getDocumentNo());
			List<RentScoreDTO> scoreLists = rentScoreMapper.getScore(dto);
			if(scoreLists.size()==0) {
				lists.get(i).setResult("미심사");
			}else {
				int totalscore = scoreLists.get(0).getCapScore()+scoreLists.get(0).getFacScore()+scoreLists.get(0).getPlanScore();
				int avrg = totalscore/3;
				if(avrg >= 80) {
					lists.get(i).setResult("합격");
				}else {
					lists.get(i).setResult("불합격");
				}
				
			}
		}
		model.addAttribute("list", lists);
		
		
	}

}
