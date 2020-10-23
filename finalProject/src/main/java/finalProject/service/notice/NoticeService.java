package finalProject.service.notice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.NoticeCommand;
import finalProject.domain.NoticeDTO;
import finalProject.mapper.NoticeMapper;

@Component
@Service
public class NoticeService {
	@Autowired
	NoticeMapper noticeMapper;

	public String noticeWrite(NoticeCommand noticeCommand, HttpServletRequest request) throws Exception{
		String location = "";
		
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setEmployeeNo(noticeCommand.getEmployeeNo());
		noticeDTO.setNoticeCon(noticeCommand.getNoticeCon());
		noticeDTO.setNoticeSub(noticeCommand.getNoticeSub());
		
		noticeMapper.noticeInsert(noticeDTO);
		location = "redirect:/notice/noticeList";
		return location;
	}
	
}
