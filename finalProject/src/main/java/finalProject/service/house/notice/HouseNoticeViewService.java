package finalProject.service.house.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.house.HouseNoticeDTO;
import finalProject.mapper.house.notice.HouseNoticeMapper;

@Component
@Service
public class HouseNoticeViewService {

	@Autowired
	HouseNoticeMapper houseNoticeMapper;
	
	public void HouseNoticeView(String noticeNo, Model model) throws Exception {
		
		houseNoticeMapper.updateReadCount(noticeNo);
		
		HouseNoticeDTO dto = houseNoticeMapper.getNoticeListView(noticeNo);
		
		model.addAttribute("dto", dto); 
		
	}
	
	
	
	
}
