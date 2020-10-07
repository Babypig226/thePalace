package finalProject.command;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TnoticeCommand {
	String tnoticeNo;
	String tnoticeName;
	String proField;
	Date tnoticeDeadline;
	Date tpassDate;
	MultipartFile tnoticeContent;
	MultipartFile update;
	Date tinterviewDate;
	String[] tinterviewAddr;

}
