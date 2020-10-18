package finalProject.service.rent.rentContract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import finalProject.domain.RentContractDTO;
import finalProject.domain.StartEndPageDTO;
import finalProject.mapper.RentContractMapper;

@Component
@Service
public class RentalContractDetailService {
	@Autowired
	RentContractMapper rentContractMapper;

	public void detailRentContract(String contractNo, Model model) {
		 StartEndPageDTO dto = new StartEndPageDTO(1L, 1L, null, contractNo);
		 RentContractDTO rdto = rentContractMapper.getRentContractList(dto).get(0);
		 model.addAttribute("list", rdto);
		
	}
	
	

}
