package finalProject.domain.house;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomMakeDTO {
	String roomNo;
	String roomName;
	Integer roomPrice;
	String roomContent;
	String rMaxCount;
	Timestamp rCheckIn;
	Timestamp rCheckOut;
	Timestamp roomRegist; 
	String employeeNo;
	String roomImage;
}
