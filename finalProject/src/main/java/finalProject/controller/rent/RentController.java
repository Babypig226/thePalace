package finalProject.controller.rent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.RentScoreCommand;
import finalProject.command.ScheduleCommend;
import finalProject.service.rent.rentDoc.RentDocDetailService;
import finalProject.service.rent.rentScore.RentScoreInsertService;
import finalProject.service.rent.spotInfo.SpotInfoDetailService;
import finalProject.service.rent.spotInfo.SpotInfoListService;
import finalProject.service.schedule.DateService;

@Controller
@RequestMapping("rent")
public class RentController {
	@Autowired
	DateService dateService;
	@Autowired
	SpotInfoListService spotInfoListService;
	@Autowired
	SpotInfoDetailService spotInfoDetailService;
	@Autowired
	RentDocDetailService rentDocDetailService;
	
	@Autowired
	RentScoreInsertService rentScoreInsertService;
	
	@RequestMapping("category")
	public String adminRentCategory() {
		return "thymeleaf/admin-rent/select-spot";
	}
	@RequestMapping("list")
	public String userSpotList(Model model, @RequestParam(value = "type")String type) {
		spotInfoListService.getSpotList(1, type, model);
		return "thymeleaf/rent/rent-spot";
	}
	@RequestMapping("detail")
	public String userSpotDetail(@RequestParam(value = "spotNo")String spotNo, Model model) {
		spotInfoDetailService.getSpotDetail(spotNo, model);
		return "thymeleaf/rent/rent-detail";
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
	@RequestMapping("short-term/schedule")
	public String shortTermSpotSchedule(@RequestParam(value = "spotNo")String spotNo, ScheduleCommend dateCommend, Model model) throws Exception{
		dateService.execute(dateCommend, model);
		return "thymeleaf/rent/short-rent-schedule";
	}
	
	

}
