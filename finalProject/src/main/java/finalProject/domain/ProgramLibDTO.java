package finalProject.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramLibDTO {
	String plibNo;
	String userId;
	String plibSubject;
	String plibContent;
	String plibFile;
	Timestamp plibDate;
	String programNo;
}
