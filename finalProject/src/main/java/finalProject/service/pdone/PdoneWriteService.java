package finalProject.service.pdone;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import finalProject.command.PdoneCommand;
import finalProject.domain.PdoneDTO;
import finalProject.mapper.PdoneMapper;

@Service
public class PdoneWriteService {

	@Autowired
	PdoneMapper pdoneMapper;

	// command값 dto에 담아서 mapper에게 패스!
	public void pdWritePro(PdoneCommand pdoneCommand, HttpSession session) {
		// TODO Auto-generated method stub
		PdoneDTO podto = new PdoneDTO();
		podto.setGlibContent(pdoneCommand.getGlibContent());
		podto.setGlibNo(pdoneCommand.getGlibNo());
		podto.setGlibSubject(pdoneCommand.getGlibSubject());
		podto.setGoodsNo(pdoneCommand.getGoodsNo());
		podto.setUserId(pdoneCommand.getUserId());
		try {
			String PATH = "/static/pdone/upload";
			String filePath = "";
			MultipartFile mf = pdoneCommand.getGlibFile();
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
			podto.setGlibFile(store);
			File file = new File(filePath + "/" + store);
			//파일저장
			mf.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pdoneMapper.pdoneInsert(podto);
		}

	}

}
