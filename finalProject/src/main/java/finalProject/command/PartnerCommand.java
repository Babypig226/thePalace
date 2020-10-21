package finalProject.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerCommand {

	Integer gcompanyNo;
	String gcompanyId;
	String gcompanyPw;
	String gcompanyName;
	String partnerName;
	String gcompanyPh;
	String gcompanyAddr;
	String gcompanyEmail;
}
