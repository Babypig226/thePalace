package finalProject.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PdoneCommand {
	Integer glibNo;
	String userId;
	String glibSubject;
	String glibContent;
	MultipartFile glibFile;
	String goodsNo;

}
