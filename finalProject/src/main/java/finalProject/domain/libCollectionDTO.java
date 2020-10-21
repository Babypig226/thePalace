package finalProject.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class libCollectionDTO {
	private ProgramLibDTO programLibDTO;
	private List<PlibReplyDTO> replies;
}
