package finalProject.service.hr.enotice;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.EnoticeCommand;
import finalProject.domain.EnoticeDTO;
import finalProject.mapper.EnoticeMapper;
import finalProject.service.addr.AddressService;
import finalProject.service.dateFormat.DateFormatService;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class EnoticeInsertService {
	@Autowired
	AddressService addressService;
	@Autowired
	EnoticeMapper enoticeMapper;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	DateFormatService dateFormatService;

	public void insertEnotice(EnoticeCommand enoticeCommand, HttpServletRequest request) {
		EnoticeDTO dto = new EnoticeDTO();
		dto.setDepartmentNo(enoticeCommand.getDepartmentNo());
		dto.setEnoticeName(enoticeCommand.getEnoticeName());
		String path = "/static/enotice/upload";
		String realPath = request.getServletContext().getRealPath(path);
		String enoticeContent = fileUploadService.fileUpload(enoticeCommand.getEnoticeContent(), realPath);
		dto.setEnoticeContent(enoticeContent);
		dto.setFpassDate(dateFormatService.dateToTimestamp(enoticeCommand.getFpassDate()));
		dto.setJoinDate(dateFormatService.dateToTimestamp(enoticeCommand.getJoinDate()));
		dto.setDeadline(dateFormatService.dateToTimestamp(enoticeCommand.getDeadline()));
		dto.setInterviewDate(dateFormatService.dateToTimestamp(enoticeCommand.getInterviewDate()));
		dto.setInterviewAddr(addressService.updateAddress(enoticeCommand.getInterviewAddr()));
		dto.setInterviewAddr(addressService.updateAddress(enoticeCommand.getInterviewAddr()));
		enoticeMapper.insertEnotice(dto);
	}
	

}
