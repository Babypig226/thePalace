package finalProject.domain;

import java.sql.Timestamp;

import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@NoArgsConstructor
public class ApplicantDTO {
	String acceptNo;
	String applicantId;
	String applicantPw;
	String applicantName;
	String applicantEname;
	Timestamp applicantBirth;
	String applicantAddr;
	String applicantPh;
	String applicantEmail;
	String applicantContent;
	String piAgree;

}
