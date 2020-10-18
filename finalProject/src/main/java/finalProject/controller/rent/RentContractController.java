package finalProject.controller.rent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.RentContractCommand;
import finalProject.service.rent.rentContract.RentalContractDetailService;
import finalProject.service.rent.rentContract.RentalContractInsertService;
import finalProject.service.rent.spot.SpotInsertService;

@Controller
@RequestMapping("rent/contract")
public class RentContractController {
	@Autowired
	RentalContractInsertService rentalContractInsertService;
	@Autowired
	SpotInsertService spotInsertService;
	@Autowired
	RentalContractDetailService rentalContractDetailService;
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String RentContractWrite(@RequestParam(value = "docNo")String documentNo, @RequestParam(value = "rentNo")String rentalNo, Model model) {
		model.addAttribute("rentNo", rentalNo);
		model.addAttribute("docNo", documentNo);
		return "thymeleaf/rent/rent-contract/rent-contract-write";
	}
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String RentContractWritePro(RentContractCommand rentContractCommand, HttpServletRequest request, Model model) {
		rentalContractInsertService.insertRentContract(rentContractCommand, request);
		String contractNo = spotInsertService.insertSpot(rentContractCommand);
		rentalContractDetailService.detailRentContract(contractNo, model);
		return "thymeleaf/rent/rent-contract/rent-contract-view";
	}

}
