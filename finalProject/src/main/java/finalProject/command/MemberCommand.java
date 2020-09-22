package finalProject.command;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	LocalDateTime userBirth;
	@NotNull(message="성별을 선택해 주세요.")
	String userGender;
	@NotNull
	@Email
	String userEmail;
	String userAddr;
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
