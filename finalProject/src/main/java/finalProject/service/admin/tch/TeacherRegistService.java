package finalProject.service.admin.tch;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.TeacherCommand;
import finalProject.domain.TeacherDTO;
import finalProject.mapper.TeacherMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class TeacherRegistService {
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	AddressService addressService;
	public void registTeacher(TeacherCommand teacherCommand, HttpSession session) {
		TeacherDTO dto = new TeacherDTO();
		dto.setTeacherId(teacherCommand.getTeacherId());
		dto.setTeacherPw("pw");
		dto.setTeacherType(teacherCommand.getTeacherType());
		dto.setResidentNo(teacherCommand.getResidentNo());
		String teacherAddr = addressService.updateAddress(teacherCommand.getTeacherAddr());
		dto.setTeacherAddr(teacherAddr);
		dto.setTeacherEmail(teacherCommand.getTeacherEmail());
		dto.setTeacherPh(teacherCommand.getTeacherPh());
		dto.setTeacherName(teacherCommand.getTeacherName());
		dto.setEmployeeNo("1");
		teacherMapper.registTeacher(dto);
	}

}
