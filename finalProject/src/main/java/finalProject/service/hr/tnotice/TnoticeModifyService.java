package finalProject.service.hr.tnotice;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.FileName;
import finalProject.command.TnoticeCommand;
import finalProject.domain.StartEndPageDTO;
import finalProject.domain.TnoticeDTO;
import finalProject.mapper.TnoticeMapper;
import finalProject.service.addr.AddressService;
import finalProject.service.dateFormat.DateFormatService;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class TnoticeModifyService {
	@Autowired
	TnoticeMapper tnoticeMapper;
	@Autowired
	AddressService addressService;
	@Autowired
	DateFormatService dateFormatService;
	@Autowired
	FileUploadService fileUploadService;
	public void tnoticeModify(TnoticeCommand tnoticeCommand, HttpServletRequest request) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, tnoticeCommand.getTnoticeNo());
		TnoticeDTO olddto = tnoticeMapper.getTnoticeList(dto).get(0);
		HttpSession session = request.getSession();
		List<FileName> list = (List<FileName>)session.getAttribute("fileList");
		String path = "/static/upload";
		String filePath = "/Users/babypig/git/thePalace/finalProject/src/main/resources"+path;
		//String realPath = request.getServletContext().getRealPath(filePath);
		TnoticeDTO newdto = new TnoticeDTO();
		if(list != null) {
			for(FileName fi : list ) {
				File file = new File(filePath + "/"	+ fi.getStoreFileName());
				if(file.exists()) file.delete();
			}
			newdto.setTnoticeContent(fileUploadService.fileUpload(tnoticeCommand.getUpdate(), filePath));
			session.removeAttribute("fileList");
		}else {
			newdto.setTnoticeContent(olddto.getTnoticeContent());
		}
		newdto.setTnoticeNo(olddto.getTnoticeNo());
		newdto.setTnoticeDeadline(dateFormatService.dateToTimestamp(tnoticeCommand.getTnoticeDeadline()));
		newdto.setTnoticeName(tnoticeCommand.getTnoticeName());
		newdto.setTpassDate(dateFormatService.dateToTimestamp(tnoticeCommand.getTpassDate()));
		newdto.setTinterviewDate(dateFormatService.dateToTimestamp(tnoticeCommand.getTinterviewDate()));
		newdto.setTinterviewAddr(addressService.updateAddress(tnoticeCommand.getTinterviewAddr()));
		tnoticeMapper.updateTnotice(newdto);
		
	}
	
	
}
