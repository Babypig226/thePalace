package finalProject.service.dep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.mapper.DepMapper;

@Component
@Service
public class DepDeleteService {
	@Autowired
	DepMapper depMapper;

	public void deleteDep(String departmentNo) {
		depMapper.deleteDep(departmentNo);
		
	}
	
	
}
