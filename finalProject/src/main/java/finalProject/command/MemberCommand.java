package finalProject.command;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class MemberCommand {
	@Size(min = 1, message = "아이디를 입력해주세요.")
	String userId;
	@NotEmpty
	String userPw;
	@NotBlank
	String userPwCon;
	@NotBlank(message = "이름을 입력해주세요!")
	@Size(min = 3, max = 12)
	String userName;
	Date userBirth;
	@NotNull(message="성별을 선택해 주세요.")
	String userGender;
	@NotNull
	@Email
	String userEmail;
	String[] userAddr;
	@NotNull
	@Size(min = 5, max = 13)
	String userPh;
	Integer userAge;
	public boolean isUserPwEqualToUserPwCon() {
		if(userPw.equals(userPwCon)) {
			return true;
		}
		return false;
	}
}
