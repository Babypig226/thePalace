package finalProject.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopCommand {
	Integer shopNo;
	String shopName;
	String shopPh;
	String shopAddr;

}
