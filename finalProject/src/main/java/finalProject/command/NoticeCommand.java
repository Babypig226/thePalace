package finalProject.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeCommand {
	String noticeNo;
	String employeeNo;
	Timestamp noticeDate;
	String noticeSub;
	String noticeCon;
}
