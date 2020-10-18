package finalProject.controller.rent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.RentCompanyCommand;
import finalProject.command.RentDocCommand;
import finalProject.command.RentScoreCommand;
import finalProject.command.ScheduleCommend;
import finalProject.service.rent.rentCompany.RentCompanyDetailService;
import finalProject.service.rent.rentCompany.RentCompanyInsertService;
import finalProject.service.rent.rentDoc.RentDocDetailService;
import finalProject.service.rent.rentDoc.RentDocInsertService;
import finalProject.service.rent.rentDoc.RentDocListService;
import finalProject.service.rent.rentScore.RentScoreInsertService;
import finalProject.service.schedule.DateService;

@Controller
@RequestMapping("rent")
public class RentController {
	@Autowired
	DateService dateService;
	@Autowired
	RentDocInsertService rentDocInsertService;
	@Autowired
	RentDocDetailService rentDocDetailService;
	@Autowired
	RentCompanyInsertService rentCompanyInsertService;
	@Autowired
	RentCompanyDetailService rentCompanyDetailService;
	@Autowired
	RentDocListService rentDocListService;
	@Autowired
	RentScoreInsertService rentScoreInsertService;
	@RequestMapping("category")
	public String RentCategory() {
		return "thymeleaf/admin-rent/select-spot";
	}
	@RequestMapping("docList")
	public String DocList(@RequestParam(value = "spotNo")String spotNo, @RequestParam(value = "page", defaultValue = "1")Integer page, Model model) {
		rentDocListService.getRentDocList(spotNo, model, page);
		return "/v-admin-rent/admin-rentdoc-list";
	}
	@RequestMapping(value = "companyRegist", method = RequestMethod.GET)
	public String CompanyRegist() {
		return "thymeleaf/rent/company-regist";
	}
	@RequestMapping(value = "companyRegist", method = RequestMethod.POST)
	public String CompanyRegistPro(RentCompanyCommand rentCompanyCommand) {
		rentCompanyInsertService.insertRentCompany(rentCompanyCommand);
		return "redirect:/";
	}
	@RequestMapping(value = "rate", method = RequestMethod.GET)
	public String RateRdoc(@RequestParam(value = "docNo")String documentNo, Model model) {
		return rentDocDetailService.getRentDocDetail(documentNo, model);
		 
	}
	@RequestMapping(value = "rate", method = RequestMethod.POST)
	public String RateRdocPro(RentScoreCommand rentScoreCommand, Model model) {
		rentScoreInsertService.insertRentScore(rentScoreCommand, model);
		return rentDocDetailService.getRentDocDetail(rentScoreCommand.getDocumentNo(), model); 
	}
	@RequestMapping("short-term/list")
	public String shortTermSpotList() {
		return "thymeleaf/rent/short-rent-spot";
	}
	@RequestMapping("short-term/detail")
	public String shortTermSpotDetail(@RequestParam(value = "spotNo")String spotNo) {
		
		return "thymeleaf/rent/short-rent-detail";
	}
	@RequestMapping("short-term/schedule")
	public String shortTermSpotSchedule(@RequestParam(value = "spotNo")String spotNo, ScheduleCommend dateCommend, Model model) throws Exception{
		dateService.execute(dateCommend, model);
		return "thymeleaf/rent/short-rent-schedule";
	}
	
	@RequestMapping(value = "short-term/docRegist", method = RequestMethod.GET)
	public String shortTermDocRegist(@RequestParam(value = "depNo")String depNo, HttpSession session, Model model) {
		rentCompanyDetailService.getRentCompanyInfo(session, model);
		return "thymeleaf/rent/short-rent-regist";
	}
	@RequestMapping(value = "short-term/docRegist", method = RequestMethod.POST)
	public String shortTermDocRegistPro(RentDocCommand rentDocCommand, HttpServletRequest request) {
		rentDocInsertService.insertRentDoc(rentDocCommand, request);
		return "redirect:/";
	}
	

}
