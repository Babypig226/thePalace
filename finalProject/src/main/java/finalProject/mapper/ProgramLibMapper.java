package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.PlibReplyDTO;
import finalProject.domain.ProgramLibDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.domain.libCollectionDTO;

@Component
@Repository(value = "finalProject.mapper.ProgramLibMapper")
public interface ProgramLibMapper {

	public void programLibInsert(ProgramLibDTO programLibDTO) throws Exception;
	public List<ProgramLibDTO> getproLibList(StartEndPageDTO startEndPageDTO) throws Exception;
	public void proLibUpdate(ProgramLibDTO dto) throws Exception;
	public void replyInsert(PlibReplyDTO predto) throws Exception;
	public libCollectionDTO getreplies(String plibNo) throws Exception;

}
