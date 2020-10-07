package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtrainingDTO {
	String trainingNo;
	String departmentNo;
	String curriculumName;
	String trainingTerm;
	Integer traineeMaxnum;
	String necessity;

}
