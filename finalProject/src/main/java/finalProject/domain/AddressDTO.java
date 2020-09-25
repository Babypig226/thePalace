package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
	String postcode;
	String roadAddress;
	String detailAddress;
	String extraAddress;
}
