package finalProject.controller.rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.SpotCommand;
import finalProject.service.rent.spotInfo.SpotInfoDeleteService;
import finalProject.service.rent.spotInfo.SpotInfoDetailService;
import finalProject.service.rent.spotInfo.SpotInfoInsertService;
import finalProject.service.rent.spotInfo.SpotInfoListService;
import finalProject.service.rent.spotInfo.SpotInfoModifyService;

@Controller
@RequestMapping("spot")
public class SpotController {
	@Autowired
	SpotInfoInsertService spotInfoInsertService;
	@Autowired
	SpotInfoListService spotInfoListService;
	@Autowired
	SpotInfoDetailService spotInfoDetailService;
	@Autowired
	SpotInfoModifyService spotInfoModifyService;
	@Autowired
	SpotInfoDeleteService spotInfoDeleteService;
	@RequestMapping("list")
	public String SpotList(@RequestParam(value = "page", defaultValue = "1")Integer page, Model model) {
		spotInfoListService.getSpotList(page, model);
		return "/v-admin-rent/admin-spot-list";
	}
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String SpotRegist() {
		return "thymeleaf/rent/spot/spot-regist";
	}
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String SpotRegistPro(SpotCommand spotCommand) {
		spotInfoInsertService.insertSpot(spotCommand);
		return "redirect:/spot/list";
	}
	@RequestMapping("detail")
	public String SpotDetail(@RequestParam(value = "spotNo")String spotNo, Model model) {
		spotInfoDetailService.getSpotDetail(spotNo, model);
		return "thymeleaf/rent/spot/spot-detail";
	}
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String SpotModify(@RequestParam(value = "spotNo")String spotNo, Model model) {
		spotInfoDetailService.getSpotDetail(spotNo, model);
		return "thymeleaf/rent/spot/spot-modify";
	}
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String SpotModifyPro(SpotCommand spotCommand) {
		spotInfoModifyService.updateSpot(spotCommand);
		return "redirect:/spot/detail?spotNo="+spotCommand.getSpotNo();
	}
	@RequestMapping("delete")
	public String SpotDelete(@RequestParam(value = "spotNo")String spotNo) {
		spotInfoDeleteService.deleteSpot(spotNo);
		return "redirect:/spot/list";
	}

}
