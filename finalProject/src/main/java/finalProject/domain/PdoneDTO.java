package finalProject.domain;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdoneDTO {
	Integer glibNo;
	String userId;
	String glibSubject;
	String glibContent;
	String glibFile;
	Timestamp glibDate;
	String goodsNo;

}
