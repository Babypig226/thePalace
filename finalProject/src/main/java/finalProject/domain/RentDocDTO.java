package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDocDTO {
	String documentNo;
	String rentReason;
	String rentPlan;
	String salesPlan;
	String displayPlan;
	String hrPlan;
	Timestamp submitDate;
	String riAgree;
	String facPledge;
	String departmentNo;
	String result;

}
