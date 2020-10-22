package finalProject.service.house.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.house.HouseNoticeDTO;
import finalProject.mapper.house.notice.HouseNoticeMapper;

@Component
@Service
public class HouseNoticeListService {
	
	@Autowired
	HouseNoticeMapper houseNoticeMapper;
	
	public void HouseNoticeList(Model model) throws Exception {
		List<HouseNoticeDTO> lists = houseNoticeMapper.getNoticeList();
		
		int count = houseNoticeMapper.getNoticeCount();
		
		model.addAttribute("count", count);
		model.addAttribute("lists", lists);
	}
	
}
