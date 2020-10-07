package finalProject.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ApplicantCommand {
	
	String enoticeNo;
	String applicantId;
	String applicantEname;
	String applicantPh;
	String applicantEmail;
	String[] applicantAddr;
	MultipartFile[] applicantContent;
	String piAgree;

}
