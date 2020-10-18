package finalProject.controller.rent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.RentDocCommand;
import finalProject.service.rent.rentCompany.RentCompanyDetailService;
import finalProject.service.rent.rentDoc.RentDocDetailService;
import finalProject.service.rent.rentDoc.RentDocInsertService;
import finalProject.service.rent.rentDoc.RentDocListService;
@Controller
@RequestMapping("rentDoc")
public class RentDocumentController {
	
	@Autowired
	RentDocInsertService rentDocInsertService;

	@Autowired
	RentDocListService rentDocListService;
	@Autowired
	RentCompanyDetailService rentCompanyDetailService;
	@Autowired
	RentDocDetailService rentDocDetailService;
	
	@RequestMapping("list")
	public String DocList(@RequestParam(value = "spotNo")String spotNo, @RequestParam(value = "page", defaultValue = "1")Integer page, Model model) {
		rentDocListService.getRentDocList(spotNo, model, page);
		return "/v-admin-rent/admin-rentdoc-list";
	}
	@RequestMapping("mylist")
	public String companyDocList(HttpSession session, Model model, @RequestParam(value = "page", defaultValue = "1")Integer page) {
		rentDocListService.getMyDocList(session, model, page);	
		return "/v-admin-rent/company-rentdoc-list";
	}
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String rentDocRegist(@RequestParam(value = "depNo")String depNo, @RequestParam(value = "spotNo")String spotNo, HttpSession session, Model model) {
		rentCompanyDetailService.getRentCompanyInfo(session, model, depNo, spotNo);
		return "thymeleaf/rent/rent-doc-regist";
	}
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String rentDocRegistPro(RentDocCommand rentDocCommand, HttpServletRequest request) {
		rentDocInsertService.insertRentDoc(rentDocCommand, request);
		return "redirect:/";
	}
	
	@RequestMapping("detail")
	public String myDocDetail(@RequestParam(value = "docNo")String documentNo, Model model, HttpSession session) {
		return rentDocDetailService.getMyRentDocDetail(documentNo, model, session);
	}

}
