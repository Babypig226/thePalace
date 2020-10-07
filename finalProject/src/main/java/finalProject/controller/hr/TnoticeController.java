package finalProject.controller.hr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.FileName;
import finalProject.command.TnoticeCommand;
import finalProject.service.file.FileDelService;
import finalProject.service.hr.tnotice.TnoticeDetailService;
import finalProject.service.hr.tnotice.TnoticeInsertService;
import finalProject.service.hr.tnotice.TnoticeListService;
import finalProject.service.hr.tnotice.TnoticeModifyService;

@Controller
@RequestMapping("tnotice")
public class TnoticeController {
	@Autowired
	TnoticeInsertService tnoticeInsertService;
	@Autowired
	TnoticeListService tnoticeListService;
	@Autowired
	TnoticeDetailService tnoticeDetailService;
	@Autowired
	TnoticeModifyService tnoticeModifyService;
	
	@RequestMapping("List")
	public String tnoticeList(Model model, @RequestParam(value = "page", defaultValue = "1")Integer page) {
		tnoticeListService.getTnoticeList(model, page);
		return "v-hr-recruit/hr-tnotice-list";
	}
	
	@RequestMapping(value = "Regist", method = RequestMethod.GET)
	public String tnoticeRegistForm() {
		return "thymeleaf/hr/tnotice/tnotice-write";
	}
	
	@RequestMapping(value = "Regist", method = RequestMethod.POST)
	public String tnoticeRegistPro(TnoticeCommand tnoticeCommand, HttpServletRequest request){
		tnoticeInsertService.tnoticeRegist(tnoticeCommand, request);
		return "redirect:/tnotice/List";
	}
	
	@RequestMapping("Detail")
	public String tnoticeDetail(@RequestParam(value = "tnoticeNo")String tnoticeNo, Model model) {
		tnoticeDetailService.getTnoticeDetail(tnoticeNo, model);
		return "thymeleaf/hr/tnotice/tnotice-detail";
	}
	
	@RequestMapping(value = "Modify", method = RequestMethod.GET)
	public String tnoticeModify(@RequestParam(value = "tnoticeNo")String tnoticeNo, Model model) {
		tnoticeDetailService.getTnoticeDetail(tnoticeNo, model);
		return "thymeleaf/hr/tnotice/tnotice-modify";
	}
	
	@RequestMapping(value = "Modify", method = RequestMethod.POST)
	 public String tnoticeModifyPro(TnoticeCommand tnoticeCommand, HttpServletRequest request) {
		tnoticeModifyService.tnoticeModify(tnoticeCommand, request);
		return "redirect:/tnotice/List";
	}
	
	@Autowired
	FileDelService fileDelService; 
	@RequestMapping("fileDel")
	public String fileDel(FileName fileName,HttpSession session, Model model) {
		fileDelService.fileSessionAdd(fileName, session, model);
		return "thymeleaf/file/delPage";
	}

}
