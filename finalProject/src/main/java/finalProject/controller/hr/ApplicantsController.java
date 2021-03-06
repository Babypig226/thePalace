package finalProject.controller.hr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import finalProject.command.ApplicantCommand;
import finalProject.service.file.FileDown;
import finalProject.service.hr.applicants.ApplicantDetailService;
import finalProject.service.hr.applicants.ApplicantsListService;
import finalProject.service.hr.applicants.ApplicantsWriteService;

@Controller
@RequestMapping("apply")
public class ApplicantsController {
	@Autowired
	ApplicantsWriteService applicantsWriteService;
	@Autowired
	ApplicantsListService applicantsListService;
	@Autowired
	ApplicantDetailService applicantDetailService;
	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String applicatnsWrite(@RequestParam(value="enoticeNo")String enoticeNo, HttpSession session, Model model) throws Exception{
		String path = applicantsWriteService.setBasicInfo(enoticeNo, session, model);
		return path;
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String applicantsRegistPro(ApplicantCommand applicantCommand, HttpServletRequest request) throws Exception{
		applicantsWriteService.registApplicant(applicantCommand, request);
		return "redirect:/enotice/Detail?enoticeNo="+applicantCommand.getEnoticeNo();
	}
	@RequestMapping("mylist")
	public String myApplyHistory(HttpSession session, Model model) {
		applicantsListService.getMyList(session, model);
		return "/v-applicants/applicants-list";
		
	}
	@RequestMapping("detail")
	public String myApplyDetail(@RequestParam(value = "acceptNo", defaultValue = "null")String acceptNo, Model model) {
		applicantDetailService.getMyApplicantDetail(acceptNo, model);
		return "thymeleaf/hr/applicants/my-detail";
	}
	
	
	@RequestMapping("list")
	public String applicantsList(@RequestParam(value = "enoticeNo")String enoticeNo, Model model) {
		applicantsListService.getApplicantsList(enoticeNo, model);
		return "/v-applicants/admin-applicants-list";
	}
	@RequestMapping("finalists")
	public String applicantsFinalists(Model model) {
		applicantsListService.getFinalists(model);
		return "/v-applicants/admin-applicants-finalists";
	}
	
	@RequestMapping("view")
	public String applicantDetail(@RequestParam(value = "acceptNo")String acceptNo, Model model) {
		return applicantDetailService.getApplicantDetail(acceptNo, model);
	}
	@Autowired
	FileDown fileDown;
	@RequestMapping("fileDown")
	public void fileDown(@RequestParam("file")String fileName, HttpServletResponse response, HttpServletRequest request) {
		String path = "/static/applicants/upload";
		fileDown.singleFileDown(path, fileName, response, request);
	}

	
	
}
