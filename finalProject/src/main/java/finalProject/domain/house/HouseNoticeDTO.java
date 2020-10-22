package finalProject.domain.house;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseNoticeDTO {
	
	String noticeNo;
	String noticeSub;
	String noticeCon;
	Integer readCount;
	Timestamp noticeDate;
	String employeeNo;
	
	
}
