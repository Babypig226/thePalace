package finalProject.service.hr.teacherRegist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TchRegistDTO;
import finalProject.mapper.TeacherRegistMapper;
import finalProject.mapper.TnoticeMapper;

@Component
@Service
public class TchRegistListService {
	@Autowired
	TnoticeMapper tnoticeMapper;
	@Autowired
	TeacherRegistMapper teacherRegistMapper;
	
	public void getTchRegistDetail(String tnoticeNo, Model model, Integer page) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, tnoticeNo);
		String tnoticeName = tnoticeMapper.getTnoticeList(dto).get(0).getTnoticeName();
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		dto.setStartPage(startRow);
		dto.setEndPage(endRow);
		List<TchRegistDTO> lists = teacherRegistMapper.getTchRegistList(dto);
		model.addAttribute("list", lists);
		model.addAttribute("tnoticeName", tnoticeName);
		
	}

}
