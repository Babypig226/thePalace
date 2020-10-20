package finalProject.service.program;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String modifiedDate = fm.format(programListCommand.getProgramDate());
		Timestamp programDate = Timestamp.valueOf(modifiedDate);
		programDTO.setProgramDate(programDate);

		programDTO.setPOption(programListCommand.getPOption());
		programDTO.setPOptionPrice(programListCommand.getPOptionPrice());
		programDTO.setUsingCount(0);
		
		String path = "/static/programImage/upload";
		String filePath = "C:/Users/ho041/Desktop/EXPORT/thePalace/finalProject/src/main/resources"+path;
		//String filePath = session.getServletContext().getRealPath(path);
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
