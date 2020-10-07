package finalProject.service.hr.enotice;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.EnoticeCommand;
import finalProject.domain.EnoticeDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.EnoticeMapper;
import finalProject.service.addr.AddressService;
import finalProject.service.dateFormat.DateFormatService;
import finalProject.service.file.FileUploadService;
import finalProject.command.FileName;

@Component
@Service
public class EnoticeModifyService {
	@Autowired
	AddressService addressService;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	EnoticeMapper enoticeMapper;
	@Autowired
	DateFormatService dateFormatService;
	public void enoticeModify(EnoticeCommand enoticeCommand, HttpServletRequest request) {
		StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, enoticeCommand.getEnoticeNo());
		EnoticeDTO olddto = enoticeMapper.getEnoticeList(dto).get(0);
		HttpSession session = request.getSession();
		List<FileName> list = (List<FileName>)session.getAttribute("fileList");
		String path = "/static/upload";
		String filePath = "/Users/babypig/git/thePalace/finalProject/src/main/resources"+path;
		//String realPath = request.getServletContext().getRealPath(path);
		EnoticeDTO newdto = new EnoticeDTO();
		if(list != null) {
			for(FileName fi : list ) {
				File file = new File(filePath + "/"	+ fi.getStoreFileName());
				if(file.exists()) file.delete();
			}
			newdto.setEnoticeContent(fileUploadService.fileUpload(enoticeCommand.getUpdate(), filePath));
			session.removeAttribute("fileList");
		}else {
			newdto.setEnoticeContent(olddto.getEnoticeContent());
		}
		newdto.setEnoticeNo(olddto.getEnoticeNo());
		newdto.setDeadline(dateFormatService.dateToTimestamp(enoticeCommand.getDeadline()));
		newdto.setEnoticeName(enoticeCommand.getEnoticeName());
		newdto.setFpassDate(dateFormatService.dateToTimestamp(enoticeCommand.getFpassDate()));
		newdto.setInterviewDate(dateFormatService.dateToTimestamp(enoticeCommand.getInterviewDate()));
		newdto.setInterviewAddr(addressService.updateAddress(enoticeCommand.getInterviewAddr()));
		newdto.setJoinDate(dateFormatService.dateToTimestamp(enoticeCommand.getJoinDate()));
		enoticeMapper.updateEnotice(newdto);
		
		
	}
	

}
