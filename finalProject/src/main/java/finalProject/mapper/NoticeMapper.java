package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.NoticeDTO;
import finalProject.domain.StartEndPageDTO;

@Component
@Repository(value = "finalProject.mapper.NoticeMapper")
public interface NoticeMapper {

	public void noticeInsert(NoticeDTO noticeDTO) throws Exception;
	public List<NoticeDTO> getNoticeList(StartEndPageDTO startEndPageDTO) throws Exception;
	public void updateNotice(NoticeDTO modn) throws Exception;
	public void noticeDel(String noticeNo);

}
