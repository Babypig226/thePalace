package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentCompanyDTO {
	String rentalNo;
	String rentalId;
	String rentalPw;
	String rentalName;
	String licenseeNo;
	String licenseeType;
	String licenseeArea;
	String licenseeCeo;
	String rentalPh;
	String prentalName;
	String prentalPh;

}
