package finalProject.command.house.fixtures;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixturesCommand {
	String equipNo;
	String roomNo;
	String equipName;
	Integer equipQty;
	String eOrderDate;
	Integer eOrderQry;
}
