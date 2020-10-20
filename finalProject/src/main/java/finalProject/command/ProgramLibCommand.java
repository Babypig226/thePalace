package finalProject.command;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramLibCommand {
	String userId;
	String programNo;
	String plibNo;
	String plibSubject;
	String plibContent;
	MultipartFile [] file; 
}
