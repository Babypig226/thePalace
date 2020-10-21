package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnoticeDTO {
	String departmentNo;
	String enoticeNo;
	Timestamp deadline;
	String enoticeName;
	String enoticeContent;
	Timestamp enoticeDate;
	Timestamp fpassDate;
	Timestamp interviewDate;
	String interviewAddr;
	Timestamp joinDate;

}
