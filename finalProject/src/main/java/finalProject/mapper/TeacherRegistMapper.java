package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TchRegistDTO;

@Repository("fileProject.mapper.TeacherRegistMapper")
public interface TeacherRegistMapper {
	public void insertTchRegist(TchRegistDTO dto);
	public List<TchRegistDTO> getTchRegistList(StartEndPageDTO dto);

}
