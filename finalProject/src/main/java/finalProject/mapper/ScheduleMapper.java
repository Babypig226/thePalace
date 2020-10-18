package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.ScheduleDTO;
@Repository("finalProject.mapper.scheduleMapper")
public interface ScheduleMapper {
	public  void scheduleInsert(ScheduleDTO dto) throws Exception;
	public List<ScheduleDTO> scheduleSelectList(ScheduleDTO dto) throws Exception;
}
