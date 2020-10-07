package finalProject.service.admin.etraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.mapper.EtrainingMapper;

@Component
@Service
public class EtrainingDeleteService {
	@Autowired
	EtrainingMapper etrainingMapper;

	public void deleteEtraining(String trainingNo) {
		etrainingMapper.deleteEtraining(trainingNo);
		
	}
	
	

}
