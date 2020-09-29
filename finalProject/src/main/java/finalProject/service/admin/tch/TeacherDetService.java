package finalProject.service.admin.tch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.mapper.TeacherMapper;

@Component
@Service
public class TeacherDetService {
	@Autowired
	TeacherMapper teacherMapper;
	
	public void deleteTeacher(String teacherNo) {
		teacherMapper.deleteTeacher(teacherNo);
	}

}
