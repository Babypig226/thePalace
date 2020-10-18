package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinterviewDTO {
	String tinterviewNo;
	String empNo;
	String regNo;
	Integer tdocScore;
	Integer tinterviewScore;
	String proGuide;
	Integer teacherTotalScore;

}
