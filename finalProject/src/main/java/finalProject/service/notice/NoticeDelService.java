package finalProject.service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.mapper.NoticeMapper;

@Component
@Service
public class NoticeDelService {
	@Autowired
	NoticeMapper noticeMapper;
	
	public void noticeDel(String noticeNo) {
		noticeMapper.noticeDel(noticeNo);
		
	}

}
