package finalProject.controller.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.NoticeCommand;
import finalProject.service.notice.NoticeDelService;
import finalProject.service.notice.NoticeDetailService;
import finalProject.service.notice.NoticeListService;
import finalProject.service.notice.NoticeModService;
import finalProject.service.notice.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	@Autowired
	NoticeListService noticeListService;
	@Autowired
	NoticeDetailService noticeDetailService;
	@Autowired
	NoticeModService noticeModService;
	@Autowired
	NoticeDelService noticeDelService;
	
	@RequestMapping("noticeSel")
	public String noticeSel() {
		return "thymeleaf/notice/notice-dep-sel";
	}
	
	@RequestMapping("noticeWrite")
	public String noticeWrite() {
		return "thymeleaf/notice/noticeWrite";
	}
	
	@RequestMapping(value="noticeWritePro", method = RequestMethod.POST)
	public String noticeWritePro(@Validated NoticeCommand noticeCommand,
								BindingResult result, HttpServletRequest request) throws Exception{
		if(result.hasErrors()) {
			System.out.println("noticeWrite오류");
			return "thymeleaf/notice/noticeWrite";
		}
		String location = noticeService.noticeWrite(noticeCommand, request);
		return location;
	}
	
	@RequestMapping("noticeList")
	public String noticeList(@RequestParam(value = "page", defaultValue = "1") Integer page,
							Model model) throws Exception{
		noticeListService.noticeList(page, model);
		return "thymeleaf/notice/noticeList";
	}
	
	@RequestMapping("noticeView")
	public String noticeView(@RequestParam(value = "noticeNo") String noticeNo,
							Model model) throws Exception{
		noticeDetailService.noticeDetail(noticeNo, model);
		return "thymeleaf/notice/noticeView"; 
	}
	
	@RequestMapping(value = "noticeModify", method = RequestMethod.GET)
	public String noticeModify(@RequestParam(value = "noticeNo") String noticeNo, 
								Model model) throws Exception{
		noticeDetailService.noticeDetail(noticeNo, model);
		return "thymeleaf/notice/noticeModify";  
	}
	
	@RequestMapping(value = "noticeModify", method = RequestMethod.POST)
	public String noticeModifyPro(NoticeCommand noticeCommand) throws Exception{
		noticeModService.noticeMod(noticeCommand);
		return "redirect:/notice/noticeList";
		//return "thymeleaf/notice/Ok";
	}
	
	@RequestMapping("noticeDelete")
	public String noticeDelete(@RequestParam(value = "noticeNo") String noticeNo) throws Exception{
		noticeDelService.noticeDel(noticeNo);
		return "redirect:/notice/noticeList";
	}

}
