package finalProject.service.admin.teacherContract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TchContractDTO;
import finalProject.domain.TeacherDTO;
import finalProject.mapper.TeacherContractMapper;
import finalProject.mapper.TeacherMapper;

@Component
@Service
public class TchContractDetailService {
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	TeacherContractMapper teacherContractMapper;
	public void tctrtDetail(String tcontractNo, Model model) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, tcontractNo);
		TchContractDTO tdto = teacherContractMapper.getContractDetail(dto);
		dto.setNum(tdto.getTeacherNo());
		TeacherDTO teacher = teacherMapper.getTeacherList(dto).get(0);
		model.addAttribute("teacher", teacher);
		model.addAttribute("list", tdto);
	}

}
