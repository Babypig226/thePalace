package finalProject.controller.hr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.EnoticeCommand;
import finalProject.command.FileName;
import finalProject.service.file.FileDelService;
import finalProject.service.hr.enotice.EnoticeDetailService;
import finalProject.service.hr.enotice.EnoticeInsertService;
import finalProject.service.hr.enotice.EnoticeListService;
import finalProject.service.hr.enotice.EnoticeModifyService;

@Controller
@RequestMapping("enotice")
public class EnoticeController {
	@Autowired
	EnoticeInsertService enoticeInsertService;
	@Autowired
	EnoticeListService enoticeListService;
	@Autowired
	EnoticeDetailService enoticeDetailService;
	@Autowired
	EnoticeModifyService enoticeModifyService;
	
	@RequestMapping("List")
	public String recruitList(Model model, @RequestParam(value = "page")Integer page) {
		enoticeListService.getEnoticeList(model, page);
		return "v-hr-recruit/hr-enotice-list";
	}
	
	@RequestMapping(value = "Regist", method = RequestMethod.GET)
	public String enoticeRegist() {
		return "thymeleaf/hr/enotice/enotice-write";
	}
	
	@RequestMapping(value = "Regist", method = RequestMethod.POST)
	public String enoticeRegistPro(EnoticeCommand enoticeCommand, HttpServletRequest request) {
		enoticeInsertService.insertEnotice(enoticeCommand, request);
		return "redirect:/enotice/List";
	}
	
	@RequestMapping("Detail")
	public String enoticeDetail(@RequestParam(value = "enoticeNo")String enoticeNo, Model model) {
		enoticeDetailService.getEnoticeDetail(enoticeNo, model);
		return "thymeleaf/hr/enotice/enotice-detail";
	}
	
	@RequestMapping(value = "Modify", method = RequestMethod.GET)
	public String enoticeModify(@RequestParam(value = "enoticeNo")String enoticeNo, Model model) {
		enoticeDetailService.getEnoticeDetail(enoticeNo, model);
		return "thymeleaf/hr/enotice/enotice-modify";
	}
	@Autowired
	FileDelService fileDelService; 
	@RequestMapping("fileDel")
	public String fileDel(FileName fileName,HttpSession session, Model model) {
		fileDelService.fileSessionAdd(fileName, session, model);
		return "thymeleaf/file/delPage";
	}
	
	@RequestMapping(value = "Modify", method = RequestMethod.POST)
	public String enoticeModifyPro(EnoticeCommand enoticeCommand, HttpServletRequest request) {
		enoticeModifyService.enoticeModify(enoticeCommand, request);
		return "redirect:/enotice/List";
	}
}
