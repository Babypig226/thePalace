package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDTO {  
	String programNo;
	String teacherNo;
	String programCategory;
	String programName;
	Integer maxCount;
	String programContent;
	String programImage;
	Integer programPrice;
	String pOption;
	Integer pOptionPrice;
	String programAddr;
	Timestamp programDate;
	Timestamp programReg;
}
