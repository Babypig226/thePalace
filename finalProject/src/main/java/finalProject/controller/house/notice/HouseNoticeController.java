package finalProject.controller.house.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.house.notice.HouseNoticeCommand;
import finalProject.service.house.notice.HouseNoticeListService;
import finalProject.service.house.notice.HouseNoticeService;
import finalProject.service.house.notice.HouseNoticeViewService;

@Controller
@RequestMapping("houseNotice")
public class HouseNoticeController {
	
	@ModelAttribute
	HouseNoticeCommand setHouseNoticeCommand() {
		return new HouseNoticeCommand();
	}
	
	@Autowired
	HouseNoticeService houseNoticeService;
	
	@Autowired
	HouseNoticeListService houseNoticeListService;
	
	@Autowired
	HouseNoticeViewService houseNoticeViewService;

	@RequestMapping(value = "houseNotice") // 공지사항 리스트
	public String houseNotice(Model model) throws Exception {
		houseNoticeListService.HouseNoticeList(model);
		return "thymeleaf/houseNotice/noticeList";
	}
	
	@RequestMapping(value = "noticeInsert") // 공지사항 등록 페이지
	public String noticeInsert() {
		return "thymeleaf/houseNotice/noticeWrite";
	}
	
	@RequestMapping(value = "noticeInsertPro", method = RequestMethod.POST) // 공지사항 등록 인서트 
	public String noticeInsertPro(HouseNoticeCommand houseNoticeCommand) throws Exception{
		
		houseNoticeService.noticeInsertPro(houseNoticeCommand);
		
		return "redirect:/houseNotice/houseNotice";
	}
	
	@RequestMapping(value = "noticeView") // 객실 상세보기  
	public String noticeView(@RequestParam(value = "noticeNo") String noticeNo, Model model) throws Exception {
		
		houseNoticeViewService.HouseNoticeView(noticeNo, model);
		
		return "thymeleaf/houseNotice/noticeView";
	}
	
	
}
