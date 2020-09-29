package finalProject.service.admin.tch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TeacherDTO;
import finalProject.mapper.TeacherMapper;
import finalProject.service.addr.AddressService;

@Component
@Service
public class TeacherListService {
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	AddressService addressService;
	
	public void getTeacherList(Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, null);
		List<TeacherDTO> lists = teacherMapper.getTeacherList(dto);
		for (int i = 0; i < lists.size(); i++) {
			lists.get(i).setTeacherAddr(addressService.rebuildAddress(lists.get(i).getTeacherAddr()));
		}
		model.addAttribute("list", lists);
	}

}
