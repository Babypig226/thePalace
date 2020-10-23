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

import finalProject.command.AuthInfo;
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

		ProgramLibDTO programLibDTO = new ProgramLibDTO();
		
		programLibDTO.setProgramNo(programLibCommand.getProgramNo());
		programLibDTO.setPlibSubject(programLibCommand.getPlibSubject());
		programLibDTO.setPlibContent(programLibCommand.getPlibContent());
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");		
		programLibDTO.setUserId(authInfo.getId());
		
		String path = "/static/programLib/upload";
		//String filePath = session.getServletContext().getRealPath(path);
		String filePath = "E:/국비수업/workspace/thePalace/finalProject/src/main/resources"+path;
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal ="";
		
		for (MultipartFile mf : programLibCommand.getFile()) {
			String original = mf.getOriginalFilename(); // 전송된 파일명 
			String originalFileExtension = // 전송된 파일명으로 부터 확장자만 자라옴   
					original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "")
					+ originalFileExtension; // 임의의 파일명 + 확장자 
			String fileSize = Long.toString(mf.getSize());
			originalTotal += original + "`";
			storeTotal += store + "`";
			fileSizeTotal += fileSize + "`";
			// 파일을저장하기 위해서 파일 객체 생성 
			File file = new File(filePath + "/" + store);
			try {
				mf.transferTo(file);
			}catch(Exception e) {
				location = "thymeleaf/lib_Board/lib_board_write";
				e.printStackTrace();
			}
		}
		
		programLibDTO.setPlibFile(storeTotal);
		programLibMapper.programLibInsert(programLibDTO);
		location = "redirect:/pgmypage/programLib";
		
		return location;
	}

}
