package finalProject.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtrainingCommand {
	String trainingNo;
	String departmentNo;
	String curriculumName;
	String trainingTerm;
	Integer traineeMaxnum;
	String necessity;

}
