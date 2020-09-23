package finalProject.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepCommand {
	String departmentName;
	String departmentPh;
	String[] departmentAddr;
}
