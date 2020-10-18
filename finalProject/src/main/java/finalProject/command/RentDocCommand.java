package finalProject.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RentDocCommand {
	String spotNo;
	String departmentNo;
	String rentReason;
	String rentalNo;
	MultipartFile rentPlan;
	MultipartFile salesPlan;
	MultipartFile hrPlan;
	MultipartFile displayPlan;
	MultipartFile facPledge;
	String riAgree;

}
