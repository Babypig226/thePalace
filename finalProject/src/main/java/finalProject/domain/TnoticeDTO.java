package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TnoticeDTO {
	String tnoticeNo;
	String employeeNo;
	Timestamp tnoticeDeadline;
	String tnoticeName;
	String tnoticeContent;
	Timestamp tnoticeDate;
	Timestamp tpassDate;
	Timestamp tinterviewDate;
	String tinterviewAddr;
	String proField;

}
