package finalProject.service.house.roomMake;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import finalProject.command.house.roomMake.RoomMakeCommand;
import finalProject.domain.house.RoomMakeDTO;
import finalProject.mapper.house.roomMake.RoomMakeMapper;

@Component
@Service
public class RoomMakeService {

	@Autowired
	RoomMakeMapper roomMakeMapper;

	public void roomInsertPro(RoomMakeCommand roomMakeCommand, HttpSession session) throws Exception {

		RoomMakeDTO roomMakeDTO = new RoomMakeDTO();

		roomMakeDTO.setRoomNo(roomMakeCommand.getRoomNo());
		roomMakeDTO.setRoomName(roomMakeCommand.getRoomName());
		roomMakeDTO.setRoomPrice(roomMakeCommand.getRoomPrice());
		roomMakeDTO.setRoomContent(roomMakeCommand.getRoomContent());
		roomMakeDTO.setRMaxCount(roomMakeCommand.getRMaxCount());
		roomMakeDTO.setEmployeeNo(roomMakeCommand.getEmployeeNo());
		//roomMakeDTO.setRCheckIn(roomMakeCommand.getRCheckIn());
		//roomMakeDTO.setRCheckOut(roomMakeCommand.getRCheckOut());
	
		

		try {
			String PATH = "/static/house/upload";
			// 위 경로 가져오는거 
			String filePath = "/Users/pangzu/finalProject/src/main/resources"+ PATH;
			
			MultipartFile mf = roomMakeCommand.getRoomImage();
			String original = mf.getOriginalFilename();
			String originalFileExension = original.substring(original.lastIndexOf("."));
			
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExension;
			
			roomMakeDTO.setRoomImage(store);
			
			File file = new File(filePath + "/" + store);
			
			//파일저장
			mf.transferTo(file);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
		
		
		roomMakeMapper.roomMakeInsert(roomMakeDTO);

	}
	}


}
