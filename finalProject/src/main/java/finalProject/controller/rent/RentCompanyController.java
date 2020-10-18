package finalProject.controller.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import finalProject.command.RentCompanyCommand;
import finalProject.service.rent.rentCompany.RentCompanyInsertService;

@Controller
@RequestMapping("rentCompany")
public class RentCompanyController {
	@Autowired
	RentCompanyInsertService rentCompanyInsertService;

	
	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String CompanyRegist() {
		return "thymeleaf/rent/rent-company/company-regist";
	}
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String CompanyRegistPro(RentCompanyCommand rentCompanyCommand) {
		rentCompanyInsertService.insertRentCompany(rentCompanyCommand);
		return "redirect:/";
	}

}
