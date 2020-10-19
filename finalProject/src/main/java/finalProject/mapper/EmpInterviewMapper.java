package finalProject.mapper;


import org.springframework.stereotype.Repository;

import finalProject.domain.EmpInterviewDTO;
import finalProject.domain.StartEndPageDTO;

@Repository("finalProject.mapper.EmpInterviewMapper")
public interface EmpInterviewMapper {
	public void insertPaperScore(EmpInterviewDTO empInterviewDTO);
	public EmpInterviewDTO getScore(StartEndPageDTO dto);
	public void updateScore(EmpInterviewDTO dto);
}
