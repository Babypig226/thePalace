package finalProject.service.rent.rentCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import finalProject.command.RentCompanyCommand;
import finalProject.domain.RentCompanyDTO;
import finalProject.mapper.RentCompanyMapper;

@Component
@Service
public class RentCompanyInsertService {
	@Autowired
	RentCompanyMapper rentCompanyMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	public void insertRentCompany(RentCompanyCommand rentCompanyCommand) {
		RentCompanyDTO dto = new RentCompanyDTO();
		dto.setLicenseeNo(rentCompanyCommand.getLicenseeNo());
		dto.setLicenseeArea(rentCompanyCommand.getLicenseeArea());
		dto.setLicenseeCeo(rentCompanyCommand.getLicenseeCeo());
		dto.setLicenseeType(rentCompanyCommand.getLicenseeType());
		dto.setPrentalName(rentCompanyCommand.getPrentalName());
		dto.setPrentalPh(rentCompanyCommand.getPrentalPh());
		dto.setRentalId(rentCompanyCommand.getRentalId());
		dto.setRentalName(rentCompanyCommand.getRentalName());
		dto.setRentalPh(rentCompanyCommand.getRentalPh());
		dto.setRentalPw(passwordEncoder.encode(rentCompanyCommand.getRentalPw()));
		rentCompanyMapper.insertRentCompany(dto);
		
	}

}
