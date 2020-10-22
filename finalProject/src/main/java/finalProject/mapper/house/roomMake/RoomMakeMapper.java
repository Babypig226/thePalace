package finalProject.mapper.house.roomMake;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.house.RoomMakeDTO;

@Component
@Repository("finalProject.mapper.house.roomMake.RoomMakeMapper")
public interface RoomMakeMapper {
	
	public void roomMakeInsert(RoomMakeDTO roomMakeDTO) throws Exception;

	public List<RoomMakeDTO>  getRoomMakeList() throws Exception;
	
	public RoomMakeDTO getListView(String roomNo) throws Exception;
	
	public void roomMakeUpdate(RoomMakeDTO dto) throws Exception;

	public void roomMakeDelete(String roomNo) throws Exception;
	
}
