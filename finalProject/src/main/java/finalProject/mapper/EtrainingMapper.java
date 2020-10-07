package finalProject.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import finalProject.domain.EtrainingDTO;
import finalProject.domain.StartEndPageDTO;

@Repository("finalProject.mapper.EtrainingMapper")
public interface EtrainingMapper {
	public void insertEtraining(EtrainingDTO etrainingDTO);
	public List<EtrainingDTO> getEtrainingList(StartEndPageDTO startEndPageDTO);
	public void updateEtraining(EtrainingDTO etrainingDTO);
	public void deleteEtraining(String trainingNo);

}
