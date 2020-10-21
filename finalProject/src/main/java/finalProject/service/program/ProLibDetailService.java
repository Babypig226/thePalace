package finalProject.service.program;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.FileName;
import finalProject.domain.ProgramLibDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.domain.libCollectionDTO;
import finalProject.mapper.ProgramLibMapper;

@Component
@Service
public class ProLibDetailService {
	@Autowired
	ProgramLibMapper programLibMapper;

	public void prolibDetail(String plibNo, Model model) throws Exception{
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, plibNo);
		ProgramLibDTO plibdto = programLibMapper.getproLibList(startEndPageDTO).get(0);
		
		String [] files = plibdto.getPlibFile().split("`");
		
		List<FileName> filelist = new ArrayList<FileName>();
		int i = 0;
		for (String file : files) {
			System.out.println("files : " + file);
			FileName fileName = new FileName(null, file, null);
			filelist.add(fileName);
			i++;
		}
		
		libCollectionDTO replies = programLibMapper.getreplies(plibNo);
		model.addAttribute("replies", replies);
		model.addAttribute("filelist", filelist);
		model.addAttribute("plibdto", plibdto);
	}

}
