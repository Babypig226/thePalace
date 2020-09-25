package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finalProject.domain.DepDTO;
import finalProject.domain.StartEndPageDTO;

@Component
@Repository("finalProject.mapper.DepMapper")
public interface DepMapper {

	public void depInsert(DepDTO dto);
	public List<DepDTO> getDepList(StartEndPageDTO dto);
	public void depModify(DepDTO dto);
	public void deleteDep(String departmentNo);
}
