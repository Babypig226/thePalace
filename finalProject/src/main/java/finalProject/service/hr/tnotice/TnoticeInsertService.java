package finalProject.service.hr.tnotice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.TnoticeCommand;
import finalProject.domain.TnoticeDTO;
import finalProject.mapper.TnoticeMapper;
import finalProject.service.addr.AddressService;
import finalProject.service.dateFormat.DateFormatService;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class TnoticeInsertService {
	
	@Autowired
	TnoticeMapper tnoticeMapper;
	@Autowired
	AddressService addressService;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	DateFormatService dateFormatService;
	public void tnoticeRegist(TnoticeCommand tnoticeCommand, HttpServletRequest request) {
		TnoticeDTO dto = new TnoticeDTO();
		dto.setProField(tnoticeCommand.getProField());
		dto.setTinterviewAddr(addressService.updateAddress(tnoticeCommand.getTinterviewAddr()));
		dto.setTnoticeName(tnoticeCommand.getTnoticeName());
		String path = "/static/upload";
		String filePath ="E:/국비수업/workspace/thePalace/finalProject/src/main/resources"+path;
		dto.setTnoticeContent(fileUploadService.fileUpload(tnoticeCommand.getTnoticeContent(), filePath));
		dto.setTinterviewDate(dateFormatService.dateToTimestamp(tnoticeCommand.getTinterviewDate()));
		dto.setTpassDate(dateFormatService.dateToTimestamp(tnoticeCommand.getTpassDate()));
		dto.setTnoticeDeadline(dateFormatService.dateToTimestamp(tnoticeCommand.getTnoticeDeadline()));
		dto.setEmployeeNo("1");
		tnoticeMapper.insertTnotice(dto);
		
	}
	
	

}
