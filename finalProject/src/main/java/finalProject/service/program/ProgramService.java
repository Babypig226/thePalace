package finalProject.service.program;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import finalProject.command.ProgramListCommand;
import finalProject.domain.ProgramDTO;
import finalProject.mapper.ProgramMapper;
@Component
@Service
public class ProgramService {
	@Autowired
	ProgramMapper programMapper;

	public String programInsert(ProgramListCommand programListCommand, 
			HttpServletRequest request) throws Exception {
		String location = "";
		HttpSession session = request.getSession();
		ProgramDTO programDTO = new ProgramDTO();
		programDTO.setProgramName(programListCommand.getProgramName());
		programDTO.setTeacherNo(programListCommand.getTeacherNo());
		programDTO.setProgramCategory(programListCommand.getProgramCategory());
		programDTO.setMaxCount(programListCommand.getMaxCount());
		programDTO.setProgramPrice(programListCommand.getProgramPrice());
		programDTO.setProgramContent(programListCommand.getProgramContent());
		programDTO.setProgramAddr(programListCommand.getProgramAddr());
		/*
		String pOptions [] = null;
		if(programListCommand.getPOption() != null) {
			pOptions = programListCommand.getPOption().split("`");
			//programDTO.setPOption(pOptions);
		}
		*/
		/*
		String pOptions [] = null;
		if(programListCommand.getPOption() != null) {
			pOptions = programListCommand.getPOption().split("`");
		}
		
		if(pOptions != null && !pOptions.equals("")) {
			for(String options : pOptions) {
				programDTO.setPOption(options);
				System.out.println("options "+options);
			}
		}
 		*/
		programDTO.setPOption(programListCommand.getPOption());
		programDTO.setPOptionPrice(programListCommand.getPOptionPrice());
		
		String path = "/static/programImage/upload";
		String filePath = session.getServletContext().getRealPath(path);
		String prImageTotal = "";
		
		for(MultipartFile mf : programListCommand.getImage()) {
			String original = mf.getOriginalFilename();	
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			
			String store = UUID.randomUUID().toString().replace("-", "")
					+ originalFileExtension;
			prImageTotal += store + "`";
			
			File file = new File(filePath + "/" + store);
			
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				location = "thymeleaf/program/programInsert";
				e.printStackTrace();
			} 
		}
		programDTO.setProgramImage(prImageTotal);
		programMapper.programInsert(programDTO);
		location = "redirect:/program/programList"; 
		return location;
	}

}
