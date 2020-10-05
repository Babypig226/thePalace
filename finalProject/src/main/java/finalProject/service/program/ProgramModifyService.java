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

import finalProject.ImageName;
import finalProject.command.ProgramListCommand;
import finalProject.domain.ProgramDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.ProgramMapper;


@Component
@Service
public class ProgramModifyService {
	@Autowired
	ProgramMapper programMapper;

	public String programModify(ProgramListCommand programListCommand, 
			HttpSession session, Model model) throws Exception{
		ProgramDTO dto = new ProgramDTO();
		dto.setProgramNo(programListCommand.getProgramNo());
		dto.setProgramName(programListCommand.getProgramName());
		dto.setProgramCategory(programListCommand.getProgramCategory());
		dto.setProgramContent(programListCommand.getProgramContent());
		dto.setMaxCount(programListCommand.getMaxCount());
		dto.setProgramAddr(programListCommand.getProgramAddr());
		dto.setProgramPrice(programListCommand.getProgramPrice());
		
		StartEndPageDTO startEndPageDTO = 
				new StartEndPageDTO(1L, 1L, "1111", dto.getProgramNo().toString());
		ProgramDTO pro = programMapper.getProgramList(startEndPageDTO).get(0);
		List<ImageName> list = (List<ImageName>)session.getAttribute("imglist");
		
		if(list != null) {
			for (ImageName in : list) {
				pro.setProgramImage(pro.getProgramImage().replace(in.getProgramImage()+"`", ""));
			}
		}
		
		String prImageTotal = "";
		File file = null;
		String path1 = "/static/programImage/upload";
		String filePath = session.getServletContext().getRealPath(path1);
		
		for (MultipartFile mf : programListCommand.getImage()) {
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
			prImageTotal += store + "`";
			
			file = new File(filePath + "/" +store);
			try {
				mf.transferTo(file);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dto.setProgramImage(prImageTotal + pro.getProgramImage());
		programMapper.programUpdate(dto);
		
		if(list != null) {
			for (ImageName in : list) {
				file = new File(filePath + "/" + in.getProgramImage().replace("`", ""));
				if(file.exists()) {
					file.delete();
				}
				session.removeAttribute("imglist");
			}
			return "redirect:/program/programDetial?programNo="+dto.getProgramNo();
		}
		return "thymeleaf/program/programModify";
	}

}
