package finalProject.service.hr.teacherRegist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TchRegistDTO;
import finalProject.domain.TinterviewDTO;
import finalProject.mapper.TeacherRegistMapper;
import finalProject.mapper.TinterviewMapper;
import finalProject.mapper.TnoticeMapper;

@Component
@Service
public class TchRegistListService {
	@Autowired
	TnoticeMapper tnoticeMapper;
	@Autowired
	TeacherRegistMapper teacherRegistMapper;
	@Autowired
	TinterviewMapper tinterviewMapper;
	
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
		for (int i = 0; i < lists.size(); i++) {
			dto.setNum(lists.get(i).getRegisterNo());
			List<TinterviewDTO> tdto = tinterviewMapper.getTinterviewList(dto);
			if(tdto.size()==0) {
				lists.get(i).setPaperResult("미심사");
				lists.get(i).setFinalResult("미심사");
			}else {
				if(tdto.get(0).getTdocScore()>=6) {
					lists.get(i).setPaperResult("서류합격");
					if(tdto.get(0).getTinterviewScore()==0||tdto.get(0).getTinterviewScore() == null) {
						lists.get(i).setFinalResult("미심사");
					}else {
						if(tdto.get(0).getTeacherTotalScore()>=12) {
							lists.get(i).setFinalResult("최종합격");
						}else {
							lists.get(i).setFinalResult("불합격");
						}
					}
					
				}
			}
			
		}
		model.addAttribute("list", lists);
		model.addAttribute("tnoticeName", tnoticeName);
		
	}

}
