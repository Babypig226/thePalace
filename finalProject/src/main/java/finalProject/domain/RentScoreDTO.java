package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentScoreDTO {
	String rscoreNo;
	Integer facScore;
	Integer planScore;
	Integer capScore;
	String departmentNo;

}
