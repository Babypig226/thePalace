package finalProject.mapper;

import org.springframework.stereotype.Repository;

import finalProject.domain.EmpInterviewDTO;

@Repository("finalProject.mapper.EmpInterviewMapper")
public interface EmpInterviewMapper {
	public void insertScore(EmpInterviewDTO empInterviewDTO);
}
