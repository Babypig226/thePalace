package finalProject.service.program;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import finalProject.FileName;
import finalProject.command.ProgramLibCommand;
import finalProject.domain.ProgramLibDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramLibMapper;

@Component
@Service
public class ProLibModifyService {
	@Autowired
	ProgramLibMapper programLibMapper; 
	public String prolibModify(ProgramLibCommand programLibCommand, 
							Model model, HttpSession session) throws Exception{
		ProgramLibDTO dto = new ProgramLibDTO();
		dto.setPlibContent(programLibCommand.getPlibContent());
		dto.setPlibSubject(programLibCommand.getPlibSubject());
		dto.setPlibNo(programLibCommand.getPlibNo());
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, null, dto.getPlibNo());		
		ProgramLibDTO plibdto = programLibMapper.getproLibList(startEndPageDTO).get(0);		
		List<FileName> list = (List<FileName>) session.getAttribute("filelist");
		
		if(list != null) {
			for (FileName fi : list) {
				plibdto.setPlibFile(plibdto.getPlibFile().replace(fi.getFile()+"`", "")); 
			}
		}
		
		String libImageTotal = "";
		File file = null;
		String path1 = "/static/programLib/upload";
		String filePath = "C:/Users/ho041/Desktop/EXPORT/thePalace/finalProject/src/main/resources"+path1;
		
		for (MultipartFile mf : programLibCommand.getFile()) {
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
			libImageTotal += store + "`";
			
			file = new File(filePath + "/" + store);
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setPlibFile(libImageTotal + plibdto.getPlibFile());
		
		programLibMapper.proLibUpdate(dto);
		
		if(list != null) {
			for (FileName in : list) {
				file = new File(filePath + "/" + in.getFile().replace("`", ""));
				if(file.exists()) {
					file.delete();
				}
				session.removeAttribute("filelist");
			}
		}
		return "redirect:/pgmypage/programLib";
	}

}
