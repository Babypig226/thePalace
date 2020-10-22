package finalProject.service.program;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.command.AuthInfo;
import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramMapper;

@Component
@Service
public class ProgramDelService {
	@Autowired
	ProgramMapper programMapper;

	public String programDel(String programNo, String programName,
							HttpSession session, Model model) throws Exception{
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, userId, programNo);
		ProgramDTO dto = programMapper.getProgramList(startEndPageDTO).get(0);
		
		if(programName.equals(dto.getProgramName())) {
			programMapper.programDelete(programNo);
			
			String [] images = dto.getProgramImage().split("`");
			String path1 = "/staic/programImage/upload";
			String filePath = "E:/국비수업/git/thePalace/finalProject/src/main/resources"+path1;
			File file = null;
			for (String ImageName : images) {
				System.out.println("ImageName : " + ImageName);
				file = new File(filePath + "/" + ImageName);
				System.out.println("file : "+file);
				if(file.exists()) {
					file.delete();
				}
			}
			return "redirect:/program/programList";
		}
		model.addAttribute("programNo", programNo);
		model.addAttribute("valid_name", "프로그램명이 다릅니다. 재확인 요함");
		return "thymeleaf/program/programDelete";
	}

}
