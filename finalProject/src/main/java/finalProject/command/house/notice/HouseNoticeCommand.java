package finalProject.command.house.notice;


import java.security.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseNoticeCommand {
	String noticeNo;
	String noticeSub;
	String noticeCon;
	Integer readCount;
	Timestamp noticeDate;
	String employeeNo;
	
}
