package finalProject.mapper;

import java.util.List;

import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;

public interface ProgramMapper {

	public void programInsert(ProgramDTO programDTO) throws Exception;
	public List<ProgramDTO> getProgramList(StartEndPageDTO startEndPageDTO) throws Exception;

}
