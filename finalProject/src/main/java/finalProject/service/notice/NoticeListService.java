package finalProject.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.NoticeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.NoticeMapper;

@Component
@Service
public class NoticeListService {
	@Autowired
	NoticeMapper noticeMapper;

	public void noticeList(Integer page, Model model) throws Exception{
		int nowPage = 1;
		if(page != null) {
			nowPage = page;
		}
		int limit = 10; 
		int limitPage = 10 ;
		Long startRow = ((long)nowPage -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		StartEndPageDTO startEndPageDTO = 
				new StartEndPageDTO(startRow, endRow, null, null);
		
		List<NoticeDTO> nlist = noticeMapper.getNoticeList(startEndPageDTO);
		System.out.println("noticelist : " + nlist);
		model.addAttribute("nlist", nlist);
	}

}
