package finalProject.service.house.roomMake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import finalProject.command.house.roomMake.RoomMakeCommand;
import finalProject.domain.house.RoomMakeDTO;
import finalProject.mapper.house.roomMake.RoomMakeMapper;

@Component
@Service
@Transactional   
public class RoomMakeModifyService {
	
	@Autowired
	RoomMakeMapper roomMakeMapper;
	
	public void roomMakeModify(RoomMakeCommand roomMakeCommand, Model model) throws Exception{
		RoomMakeDTO dto = new RoomMakeDTO();
		dto.setRoomNo(roomMakeCommand.getRoomNo());
		//System.out.println("1" + roomMakeCommand.getRoomNo());
		dto.setRoomName(roomMakeCommand.getRoomName());
		//System.out.println("2" + roomMakeCommand.getRoomName());
		dto.setRoomPrice(roomMakeCommand.getRoomPrice());
		//System.out.println("3" + roomMakeCommand.getRoomPrice());
		dto.setRMaxCount(roomMakeCommand.getRMaxCount());
		//System.out.println("4" + roomMakeCommand.getRMaxCount());
		dto.setRoomContent(roomMakeCommand.getRoomContent());
		//System.out.println("5" + roomMakeCommand.getRoomContent() );
		dto.setEmployeeNo(roomMakeCommand.getEmployeeNo());
		//System.out.println("6" + roomMakeCommand.getEmployeeNo());
		
		roomMakeMapper.roomMakeUpdate(dto);
	}
}
