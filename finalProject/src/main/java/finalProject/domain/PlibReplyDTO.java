package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlibReplyDTO {
	String plibNo;
	String preplyNo;
	String preplyContent;
	Timestamp preplyDate;
	String employeeNo;
}
