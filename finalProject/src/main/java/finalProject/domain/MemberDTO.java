package finalProject.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	String userId;
	String userPw;
	String userName;
	String userPh;
	String userEmail;
	String userAddr;
	String userGender;
	Integer userAge;
	Timestamp userBirth;
	String joinOk;
	Timestamp userRegist;
	
	StartEndPageDTO startEndPageDTO;

	public MemberDTO(String userId, String userPw, String userName, String userPh, String userEmail, String userAddr,
			String userGender, Integer userAge, Timestamp userBirth, String joinOk, Timestamp userRegist) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userPh = userPh;
		this.userEmail = userEmail;
		this.userAddr = userAddr;
		this.userGender = userGender;
		this.userAge = userAge;
		this.userBirth = userBirth;
		this.joinOk = joinOk;
		this.userRegist = userRegist;
	}
	
}
