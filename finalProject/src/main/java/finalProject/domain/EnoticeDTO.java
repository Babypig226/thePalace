package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnoticeDTO {
	String enoticeName;
	Timestamp deadline;
	Timestamp fpassDate;
	Timestamp interviewDate;
	Timestamp joinDate;
	String interviewAddr;
	String enoticeContent;
	String enoticeNo;
	String departmentNo;
	Timestamp enoticeDate;
}
