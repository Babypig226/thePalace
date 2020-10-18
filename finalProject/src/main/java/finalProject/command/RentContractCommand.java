package finalProject.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RentContractCommand {
	String rentalNo;
	String documentNo;
	String rentalType;
	String rentalTerm;
	String rentalPay;
	String rentalAcc;
	String rentalDeadline;
	MultipartFile[] rentalData;
	String rentalPurpose;
}
