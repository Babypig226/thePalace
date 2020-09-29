package finalProject.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCommand {
	String teacherNo;
	String teacherId;
	String teacherName;
	String teacherType;
	String residentNo;
	String[] teacherAddr;
	String teacherEmail;
	String teacherPh;

}
