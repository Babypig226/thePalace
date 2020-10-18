package finalProject.service.rent.rentContract;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.RentContractCommand;
import finalProject.domain.RentContractDTO;
import finalProject.mapper.RentContractMapper;
import finalProject.service.file.FileUploadService;

@Component
@Service
public class RentalContractInsertService {
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	RentContractMapper rentContractMapper;
	public void insertRentContract(RentContractCommand rentContractCommand, HttpServletRequest request) {
		RentContractDTO dto = new RentContractDTO();
		dto.setDocumentNo(rentContractCommand.getDocumentNo());
		dto.setRentalType(rentContractCommand.getRentalType());
		dto.setRentalTerm(rentContractCommand.getRentalTerm());
		dto.setRentalPay(rentContractCommand.getRentalPay());
		dto.setRentalPurpose(rentContractCommand.getRentalPurpose());
		dto.setRentalAcc(rentContractCommand.getRentalAcc());
		dto.setRentalDeadline(rentContractCommand.getRentalDeadline());
		dto.setRentalNo(rentContractCommand.getRentalNo());
		System.out.println("rentalNo : "+dto.getRentalNo());
		String path = "/static/rent/rent-contract/upload";
		String filePath = request.getServletContext().getRealPath(path);
		dto.setRentalData(fileUploadService.multipleFileUpload(rentContractCommand.getRentalData(), filePath));
		rentContractMapper.insertRentContract(dto);
		
	}

}
