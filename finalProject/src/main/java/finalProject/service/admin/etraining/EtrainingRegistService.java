package finalProject.service.admin.etraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.EtrainingCommand;
import finalProject.domain.EtrainingDTO;
import finalProject.mapper.EtrainingMapper;

@Component
@Service
public class EtrainingRegistService {
	@Autowired
	EtrainingMapper etrainingMapper;

	public void insertEtraining(EtrainingCommand etrainingCommand) {
		EtrainingDTO dto = new EtrainingDTO();
		dto.setCurriculumName(etrainingCommand.getCurriculumName());
		dto.setDepartmentNo(etrainingCommand.getDepartmentNo());
		dto.setNecessity(etrainingCommand.getNecessity());
		dto.setTraineeMaxnum(etrainingCommand.getTraineeMaxnum());
		dto.setTrainingTerm(etrainingCommand.getTrainingTerm());
		etrainingMapper.insertEtraining(dto);
	}
	
	

}
