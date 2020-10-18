package finalProject.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TchRegistCommand {
	String tnoticeNo;
	MultipartFile teacherLicense;
	String teacherLevel;
	MultipartFile registerContent;
	MultipartFile programRegist;

}
