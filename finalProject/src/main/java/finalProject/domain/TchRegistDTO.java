package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TchRegistDTO {
	String registerNo;
	String registerContent;
	String ProgramRegist;
	String teacherLevel;
	String teacherLicense;
	String paperResult;
	String finalResult;

}
