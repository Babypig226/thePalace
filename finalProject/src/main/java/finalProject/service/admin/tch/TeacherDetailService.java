package finalProject.service.admin.tch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.AddressDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TeacherDTO;
import finalProject.mapper.TeacherMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class TeacherDetailService {
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	AddressService addressService;
	
	public void getTeacherDetail(String teacherNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, teacherNo);
		TeacherDTO teacher = teacherMapper.getTeacherList(dto).get(0);
		AddressDTO addr = addressService.devideAddress(teacher.getTeacherAddr());
		teacher.setTeacherAddr(addressService.rebuildAddress(teacher.getTeacherAddr()));
		model.addAttribute("list", teacher);
		model.addAttribute("addr", addr);
	}
}
