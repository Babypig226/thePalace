package finalProject.service.admin.tch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.TeacherCommand;
import finalProject.domain.TeacherDTO;
import finalProject.mapper.TeacherMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class TeacherModService {
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	AddressService addressService;
	public void modifyTeacher(TeacherCommand teacherCommand) {
		TeacherDTO teacher = new TeacherDTO();
		teacher.setTeacherNo(teacherCommand.getTeacherNo());
		teacher.setTeacherPh(teacherCommand.getTeacherPh());
		teacher.setTeacherEmail(teacherCommand.getTeacherEmail());
		String teacherAddr = addressService.updateAddress(teacherCommand.getTeacherAddr());
		teacher.setTeacherAddr(teacherAddr);
		teacherMapper.updateTeacher(teacher);
		
	}
	

}
