package finalProject.command;

import lombok.Data;

@Data
public class RentScoreCommand {
	String documentNo;
	String departmentNo;
	Integer facScore;
	Integer planScore;
	Integer capScore;

}
