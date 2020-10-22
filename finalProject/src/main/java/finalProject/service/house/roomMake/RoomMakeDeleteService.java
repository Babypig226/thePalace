package finalProject.service.house.roomMake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.mapper.house.roomMake.RoomMakeMapper;

@Component
@Service
public class RoomMakeDeleteService {
	@Autowired
	RoomMakeMapper roomMakeMapper; 
	
	public void roomDeletePro(String roomNo, Model model) throws Exception {
		model.addAttribute("roomNo", roomNo);
		
		roomMakeMapper.roomMakeDelete(roomNo);
	}
}
