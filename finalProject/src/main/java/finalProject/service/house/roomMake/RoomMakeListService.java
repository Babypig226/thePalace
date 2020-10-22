package finalProject.service.house.roomMake;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.house.RoomMakeDTO;
import finalProject.mapper.house.roomMake.RoomMakeMapper;

@Component
@Service
public class RoomMakeListService {
	@Autowired
	RoomMakeMapper roomMakeMapper;
	
	public void RoomMakeList(Model model) throws Exception {
		List<RoomMakeDTO> lists = roomMakeMapper.getRoomMakeList();
		
		for(int i = 0; i < lists.size(); i++){
			System.out.println("roomListService "+lists.get(i).getRoomName());
		}
		
		//model.addAttribute("count", count);
		model.addAttribute("lists", lists);
	}
}
