package finalProject.service.house.roomMake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.house.RoomMakeDTO;
import finalProject.mapper.house.roomMake.RoomMakeMapper;

@Component
@Service
public class RoomMakeViewService {
	
	@Autowired
	RoomMakeMapper roomMakeMapper;
	
	public void RoomMakeView(String roomNo, Model model) throws Exception {
		
		//roomMakeMapper.updateReadCount(roomNo);
		
		RoomMakeDTO dto = roomMakeMapper.getListView(roomNo);
		
		model.addAttribute("dto", dto);
	}
}
