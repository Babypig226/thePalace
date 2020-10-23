package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {
	String noticeNo;
	String employeeNo;
	String noticeSub;
	String noticeCon;
	Integer readCount;
	Timestamp noticeDate;	
}
