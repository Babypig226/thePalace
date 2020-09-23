package finalProject.service.program;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import finalProject.command.ProgramListCommand;
import finalProject.domain.ProgramDTO;
import finalProject.mapper.ProgramMapper;

public class ProgramService {
	@Autowired
	ProgramMapper programMapper;

	public void programInsert(ProgramListCommand programListCommand, 
			HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		ProgramDTO programDTO = new ProgramDTO();
		programDTO.setProgramName(programListCommand.getProgramName());
		programDTO.setTeacherNo(programListCommand.getTeacherNo());
		programDTO.setProgramCategory(programListCommand.getProgramCategory());
		programDTO.setMaxCount(programListCommand.getMaxCount());
		
		programDTO.setProgramPrice(programListCommand.getProgramPrice());
		programDTO.setProgramContent(programListCommand.getProgramContent());
		programDTO.setProgramAddr(programListCommand.getProgramAddr());
		programDTO.setPOption(programListCommand.getPOption());
		programDTO.setPOptionPrice(programListCommand.getPOptionPrice());
		
		String path = "WEB-INF/programImage/upload";
		String filePath = session.getServletContext().getRealPath(path);
		String programImage = "";
		
		for(MultipartFile mf : programListCommand.getProgramImage()) {
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			
			String store = UUID.randomUUID().toString().replace("-", "")
					+ originalFileExtension;
			programImage += store + "`";
			
			File file = new File(filePath + "\\" + store);
			
			try {
				mf.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		programDTO.setProgramImage(programImage);
		programMapper.programInsert(programDTO);
	}

}
