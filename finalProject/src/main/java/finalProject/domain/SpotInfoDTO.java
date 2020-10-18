package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpotInfoDTO {
	String spotNo;
	String spotName;
	String spotPurpose;
	Integer spotPrice;

}
