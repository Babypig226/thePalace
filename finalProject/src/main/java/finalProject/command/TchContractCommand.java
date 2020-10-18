package finalProject.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TchContractCommand {
	String teacherNo;
	String tcontractType;
	String tcontractTerm;
	Integer teacherSal;
	String teacherAccount;
	String checkSafe;
	MultipartFile tidentitiCard;
	MultipartFile tcopyBankbook;

}
