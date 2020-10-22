package finalProject.mapper.house.notice;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.house.HouseNoticeDTO;

@Component
@Repository("finalProject.mapper.house.notice.HouseNoticeMapper")
public interface HouseNoticeMapper {
	
	public void noticeInsert(HouseNoticeDTO houseNoticeDTO) throws Exception;

	public List<HouseNoticeDTO> getNoticeList() throws Exception;

	public Integer getNoticeCount() throws Exception;

	public HouseNoticeDTO getNoticeListView(String noticeNo);

	public void updateReadCount(String noticeNum) throws Exception;
	

}
