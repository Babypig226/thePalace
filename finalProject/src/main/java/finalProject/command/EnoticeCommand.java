package finalProject.command;


import java.sql.Date;


import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnoticeCommand {
	String enoticeNo;
	String departmentNo;
	String enoticeName;
	Date deadline;
	Date fpassDate;
	Date interviewDate;
	Date joinDate;
	String[] interviewAddr;
	MultipartFile enoticeContent;
	MultipartFile update;

}
