package finalProject.service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.NoticeCommand;
import finalProject.domain.NoticeDTO;
import finalProject.mapper.NoticeMapper;

@Component
@Service
public class NoticeModService {
	@Autowired
	NoticeMapper noticeMapper;
	
	public void noticeMod(NoticeCommand noticeCommand) throws Exception{
		System.out.println("noticeModService");
		NoticeDTO modn = new NoticeDTO();
		modn.setNoticeNo(noticeCommand.getNoticeNo());
		System.out.println(modn.getNoticeNo());
		modn.setEmployeeNo(noticeCommand.getEmployeeNo());
		System.out.println(modn.getEmployeeNo());
		modn.setNoticeCon(noticeCommand.getNoticeCon());
		System.out.println(modn.getNoticeCon());
		modn.setNoticeSub(noticeCommand.getNoticeSub());
		System.out.println(modn.getNoticeSub());
		
		noticeMapper.updateNotice(modn);
	}

}
