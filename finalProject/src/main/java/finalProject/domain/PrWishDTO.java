package finalProject.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrWishDTO {
	String programNo;
	String userId;
	
	List<ProgramDTO> pro;
}