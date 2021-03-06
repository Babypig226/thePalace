package finalProject.command;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramListCommand {
	String programNo;
	@NotEmpty(message = "프로그램명을 입력해주세요.")
	String programName;
	String teacherNo;
	String programCategory;
	Integer maxCount;
	//MultipartFile [] programImage;
	MultipartFile [] Image;
	@NotNull
	Integer programPrice;
	String programContent;
	String programAddr;
	String pOption;
	Integer pOptionPrice;
	String programReg;
	Date programDate;
}
