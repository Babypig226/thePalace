package finalProject.service.house.notice;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import finalProject.command.house.notice.HouseNoticeCommand;
import finalProject.domain.house.HouseNoticeDTO;
import finalProject.mapper.house.notice.HouseNoticeMapper;

@Component
@Service
public class HouseNoticeService {
	
	@Autowired
	HouseNoticeMapper houseNoticeMapper;
	
	public void noticeInsertPro(HouseNoticeCommand houseNoticeCommand) throws Exception{
		
		HouseNoticeDTO houseNoticeDTO = new HouseNoticeDTO();
		
		houseNoticeDTO.setNoticeNo(houseNoticeCommand.getNoticeNo());
		//System.out.println("1 " + houseNoticeCommand.getNoticeNo());
		houseNoticeDTO.setNoticeSub(houseNoticeCommand.getNoticeSub());
		//System.out.println("2 " + houseNoticeCommand.getNoticeSub());
		houseNoticeDTO.setNoticeCon(houseNoticeCommand.getNoticeCon());
		//System.out.println("3 " + houseNoticeCommand.getNoticeCon() );
		houseNoticeDTO.setEmployeeNo(houseNoticeCommand.getEmployeeNo());
		//System.out.println("4 " + houseNoticeCommand.getEmployeeNo());
		
		houseNoticeDTO.setNoticeDate(houseNoticeCommand.getNoticeDate());
		
	
			houseNoticeMapper.noticeInsert(houseNoticeDTO);
		
		
		
		
		
	}
}
