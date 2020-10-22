package finalProject.command.house.roomMake;

import org.springframework.web.multipart.MultipartFile;

//import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomMakeCommand {
	String roomNo;
	String roomName;
	Integer roomPrice;
	String roomContent;
	String rMaxCount;
	String employeeNo;
	MultipartFile roomImage;
	
	
	
	//Timestamp rCheckIn;
	// Timestamp rCheckOut;
	

}
