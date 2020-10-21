package finalProject.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdorderCommand {
	Integer orderNo;
	Integer gcompanyNo;
	String  goodsNo;

}
