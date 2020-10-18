package finalProject.service.rent.rentDoc;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.RentDocCommand;
import finalProject.domain.RentDocDTO;
import finalProject.mapper.RentDocMapper;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class RentDocInsertService {
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	RentDocMapper rentDocMapper;

	public void insertRentDoc(RentDocCommand rentDocCommand, HttpServletRequest request) {
		RentDocDTO dto = new RentDocDTO();
		SimpleDateFormat dateForm = new SimpleDateFormat("HHmmss");
		String num = dateForm.format(new Date());
		dto.setDocumentNo(rentDocCommand.getSpotNo()+"-"+ rentDocCommand.getRentalNo()+"-"+num);
		dto.setDepartmentNo(rentDocCommand.getDepartmentNo());
		dto.setRentReason(rentDocCommand.getRentReason());
		dto.setRiAgree(rentDocCommand.getRiAgree());
		String path = "/static/rent/rent-doc/upload";
		String filePath = request.getServletContext().getRealPath(path);
		dto.setRentPlan(fileUploadService.fileUpload(rentDocCommand.getRentPlan(), filePath));
		dto.setSalesPlan(fileUploadService.fileUpload(rentDocCommand.getSalesPlan(), filePath));
		dto.setDisplayPlan(fileUploadService.fileUpload(rentDocCommand.getDisplayPlan(), filePath));
		dto.setHrPlan(fileUploadService.fileUpload(rentDocCommand.getHrPlan(), filePath));
		dto.setFacPledge(fileUploadService.fileUpload(rentDocCommand.getFacPledge(), filePath));
		rentDocMapper.insertRentDoc(dto);
		
		
		
	}
	

}
