package finalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepDTO {
	Integer DepartmentNo;
	String DepartmentName;
	String DepartmentPh;
	String DepartmentAddr;

}
