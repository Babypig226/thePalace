package finalProject.service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.NoticeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.NoticeMapper;

@Component
@Service
public class NoticeDetailService {
	@Autowired
	NoticeMapper noticeMapper;
	
	public void noticeDetail(String noticeNo, Model model) throws Exception{
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, noticeNo);
		NoticeDTO ndto = noticeMapper.getNoticeList(startEndPageDTO).get(0);
		model.addAttribute("ndto", ndto);
	}

}
