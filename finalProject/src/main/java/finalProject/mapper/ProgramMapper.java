package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;

@Component
@Repository(value = "finalProject.mapper.ProgramMapper")
public interface ProgramMapper {

	public void programInsert(ProgramDTO programDTO) throws Exception;
	public List<ProgramDTO> getProgramList(StartEndPageDTO startEndPageDTO) throws Exception;
	public ProgramDTO programDetail(ProgramDTO pgdto) throws Exception;
	public void programUpdate(ProgramDTO dto) throws Exception;
	public void programDelete(String programNo) throws Exception;
	public List<ProgramDTO> mainlist() throws Exception;
	public List<ProgramDTO> culture();
	public List<ProgramDTO> tour();
	public List<ProgramDTO> fitness();

}
