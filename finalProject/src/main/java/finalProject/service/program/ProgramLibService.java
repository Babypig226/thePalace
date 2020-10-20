package finalProject.service.program;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import finalProject.command.ProgramLibCommand;
import finalProject.domain.ProgramDTO;
import finalProject.domain.ProgramLibDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramLibMapper;
import finalProject.mapper.ProgramMapper;

@Component
@Service
public class ProgramLibService {
	@Autowired
	ProgramLibMapper programLibMapper;
	
	public String writePro(ProgramLibCommand programLibCommand,
							HttpServletRequest request) throws Exception{
		String location = "";
		HttpSession session = request.getSession();

		ProgramLibDTO programLibDTO = new ProgramLibDTO();
		
		programLibDTO.setProgramNo(programLibCommand.getProgramNo());
		programLibDTO.setPlibSubject(programLibCommand.getPlibSubject());
		programLibDTO.setPlibContent(programLibCommand.getPlibContent());
		programLibDTO.setUserId("1111");
		
		String path = "/static/programLib/upload";
		//String filePath = session.getServletContext().getRealPath(path);
		String filePath = "C:/Users/ho041/Desktop/EXPORT/thePalace/finalProject/src/main/resources"+path;
		String prLibFile = "";
		
		for (MultipartFile mf : programLibCommand.getFile()) {
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			
			String store = UUID.randomUUID().toString().replace("-", "")
							+ originalFileExtension;
			
			prLibFile += store + "`";
			
			File file = new File(filePath + "/" + store);
			System.out.println(file.getPath());
			
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				location = "thymeleaf/programLib/one_to_one_write";
				e.printStackTrace();
			}
		}
		
		programLibDTO.setPlibFile(prLibFile);
		programLibMapper.programLibInsert(programLibDTO);
		location = "redirect:/pgmypage/programLib";
		
		return location;
	}

}
